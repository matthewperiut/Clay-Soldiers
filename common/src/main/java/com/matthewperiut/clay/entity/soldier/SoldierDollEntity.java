package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.ai.goal.MeleeAttackTinyGoal;
import com.matthewperiut.clay.entity.ai.goal.SoldierAIFindTarget;
import com.matthewperiut.clay.entity.ai.goal.SoliderAIFollowTarget;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.teams.ITeam;
import com.matthewperiut.clay.extension.ISpawnReasonExtension;
import com.matthewperiut.clay.nbt.NBTValues;
import com.matthewperiut.clay.network.packet.SyncUpgradesS2CPacket;
import com.matthewperiut.clay.registry.ItemRegistry;
import com.matthewperiut.clay.registry.TeamRegistry;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.UpgradeInstance;
import com.matthewperiut.clay.upgrade.UpgradeManager;
import dev.architectury.extensions.network.EntitySpawnExtension;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

import static com.matthewperiut.clay.entity.soldier.teams.ITeam.NBT_IDENTIFIER;
import static com.matthewperiut.clay.registry.TeamRegistry.CLAY_TEAM;

public class SoldierDollEntity extends PathAwareEntity implements GeoAnimatable, EntitySpawnExtension {
    public static final Identifier TEXTURE_ID = Identifier.of(ClayMod.MOD_ID, "textures/entity/soldier/lightgray.png");
    private final AnimatableInstanceCache animationCache = GeckoLibUtil.createInstanceCache(this);
    public HashSet<ISoldierUpgrade> upgrades = new HashSet<>();
    public HashMap<ISoldierUpgrade, UpgradeInstance> upgradeInstances = new HashMap<>();
    public Queue<ISoldierUpgrade> removeUpgrades = new LinkedList<>();
    protected boolean isLightBlockUnaffected = false;
    private Entity followingEntity;
    private ITeam team;
    private boolean isAnimating = false;

    public SoldierDollEntity(EntityType<? extends PathAwareEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return PathAwareEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 5.00f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0f).add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.0f).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.hasVehicle()) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("animation.clay_soldier.ride"));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("animation.clay_soldier.run"));
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("animation.clay_soldier.idle"));
        }
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState<SoldierDollEntity> event) {
        if (this.handSwinging) {
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().thenPlay("animation.clay_soldier.attack"));
            this.handSwinging = false;
            return PlayState.STOP;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(
                new AnimationController<>(this, "controller", 0, this::predicate),
                new AnimationController<>(this, "attackController", 1, this::attackPredicate)
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animationCache;
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            this.isAnimating = !this.isAnimating;
        }
        return super.interactAt(player, hitPos, hand);
    }

    protected void selectTargets() {
        this.targetSelector.add(3, new SoldierAIFindTarget.Mount(this, TypeFilter.instanceOf(HorseDollEntity.class)));
        this.targetSelector.add(3, new SoldierAIFindTarget.Upgrade(this, TypeFilter.instanceOf(ItemEntity.class)));
        targetSelector.add(4, new ActiveTargetGoal<>(this, SoldierDollEntity.class, true, (e) -> {
            if (e instanceof SoldierDollEntity target) {
                return !target.getTeam().isinSameTeam(this.getTeam().getTeamId());
            }
            return false;
        }));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1, 1));
        this.goalSelector.add(3, new MeleeAttackTinyGoal(this, 1, false));
        this.goalSelector.add(2, new SoliderAIFollowTarget.Mount(this, 1));
        this.goalSelector.add(2, new SoliderAIFollowTarget.Upgrade(this, 1));
        this.goalSelector.add(1, new SwimGoal(this));

        selectTargets(); // priority 3

        super.initGoals();
    }

    @Override
    public double getTick(Object o) {
        return age;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        return SoundEvents.BLOCK_GRAVEL_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GRAVEL_STEP;
    }
//region EVENTS

    @Override
    public void onDeath(DamageSource damageSource) {
        if (this.hasVehicle()) Objects.requireNonNull(this.getVehicle()).kill();
        if (damageSource.getType().equals(this.getWorld().getDamageSources().inFire().getType()) || (damageSource.getType().equals(this.getWorld().getDamageSources().lava().getType())))
            getWorld().spawnEntity(new ItemEntity(getWorld(), getX(), getY(), getZ(), new ItemStack(ItemRegistry.BRICK_SOLDIER, 1)));
        for (ISoldierUpgrade upgrade : upgrades) {
            getWorld().spawnEntity(new ItemEntity(getWorld(), getX(), getY(), getZ(), upgrade.getUpgradeItem()));
        }
        super.onDeath(damageSource);
    }

    @Override
    public void onAttacking(Entity target) {
        super.onAttacking(target);

        if (target instanceof SoldierDollEntity targetSoldier) {
            this.upgrades.forEach(u -> u.onAttack(targetSoldier, this));
            ISoldierUpgrade upgrade;
            while ((upgrade = removeUpgrades.poll()) != null) {
                UpgradeManager.INSTANCE.removeUpgrade(this, upgrade);
            }
        }
    }

    @Override
    public void onDamaged(DamageSource damageSource) {
        super.onDamaged(damageSource);
    }

    @Override
    public boolean handleAttack(Entity attacker) {
        if (attacker instanceof PlayerEntity) {
            kill();
        }
        if (attacker instanceof SoldierDollEntity attackerSoldier) {
            this.upgrades.forEach(u -> u.onHit(attackerSoldier, this));
            ISoldierUpgrade upgrade;
            while ((upgrade = removeUpgrades.poll()) != null) {
                UpgradeManager.INSTANCE.removeUpgrade(this, upgrade);
            }
        }

        return super.handleAttack(attacker);
    }

    @Override
    public boolean tryAttack(Entity target) {
        swingHand(Hand.MAIN_HAND);
        return super.tryAttack(target);
    }
//endregion EVENTS

    @Override
    public boolean cannotDespawn() {
        if (this instanceof ISpawnReasonExtension) {
            return ((ISpawnReasonExtension) this).clay$getSpawnReason() == SpawnReason.SPAWN_EGG;
        }
        return super.cannotDespawn();
    }

    public Entity getFollowingEntity() {
        return followingEntity;
    }

    public void setFollowingEntity(Entity followingEntity) {
        this.followingEntity = followingEntity;
    }

    public boolean maxedOutUpgrades() {
        return false;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setTeam(@NotNull ITeam team) {
        this.team = team;
    }

    //region SYNC

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        short teamId = nbt.getShort(NBT_IDENTIFIER);
        Optional<Map.Entry<RegistryKey<ITeam>, ITeam>> teamOptional = TeamRegistry.SOLDIER_TEAMS.entrySet()
                .stream()
                .filter(t -> t.getValue().isinSameTeam(teamId))
                .findFirst();
        setTeam(teamOptional.map(Map.Entry::getValue).orElse(CLAY_TEAM.get()));

        NbtList nbtListForUpgrades = nbt.getList(NBTValues.SOLDIER_UPGRADES.getKey(), NbtElement.COMPOUND_TYPE);
        for (int i = 0; i < nbtListForUpgrades.size(); i++) {
            NbtCompound nbtCompound = nbtListForUpgrades.getCompound(i);
            Identifier identifier = Identifier.of(nbtCompound.getString(NBTValues.SOLDIER_UPGRADES_ID.getKey()));
            UpgradeManager.INSTANCE.handleNBTRead(this, identifier, nbtCompound);
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putShort(NBT_IDENTIFIER, getTeam().getTeamId());
        NbtList nbtListForUpgrades = new NbtList();
        for (ISoldierUpgrade upgrade : this.upgrades) {
            NbtCompound nbtElement = new NbtCompound();
            UpgradeManager.INSTANCE.handleNBTWrite(this, upgrade, nbtElement);
            nbtListForUpgrades.add(nbtElement);
        }
        nbt.put(NBTValues.SOLDIER_UPGRADES.getKey(), nbtListForUpgrades);
    }

    @Override
    public void saveAdditionalSpawnData(PacketByteBuf buf) {
        SyncUpgradesS2CPacket syncUpgradeData = new SyncUpgradesS2CPacket(this);
        syncUpgradeData.write(buf);
    }

    @Override
    public void loadAdditionalSpawnData(PacketByteBuf buf) {
        SyncUpgradesS2CPacket syncUpgradeData = new SyncUpgradesS2CPacket(buf);
        this.upgrades = new HashSet<>(syncUpgradeData.getUpgrades());
        this.upgrades.forEach(u -> u.onAdd(this));
    }
//endregion SYNC

//region CLIENT

    @Environment(EnvType.CLIENT)
    public boolean isLightBlockUnaffected() {
        return isLightBlockUnaffected;
    }

    @Environment(EnvType.CLIENT)
    public void setLightBlockUnaffected(boolean lightBlockUnaffected) {
        this.isLightBlockUnaffected = lightBlockUnaffected;
    }

//endregion

    // temp stick fix
    public static final TrackedData<Boolean> HAS_STICK;

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(HAS_STICK, false);

    }
    static {
        HAS_STICK = DataTracker.registerData(SoldierDollEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    @Override
    public void tick() {
        super.tick();
        if (!getWorld().isClient() && age % 20 == 0) {
            if(getMainHandStack().isOf(Items.STICK)) {
                dataTracker.set(HAS_STICK, true);
            }
        }
    }
}