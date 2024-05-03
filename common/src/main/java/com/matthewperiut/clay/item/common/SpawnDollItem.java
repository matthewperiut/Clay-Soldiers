package com.matthewperiut.clay.item.common;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.entity.soldier.teams.ITeam;
import com.matthewperiut.clay.registry.TeamRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.matthewperiut.clay.registry.TeamRegistry.CLAY_TEAM;

public class SpawnDollItem extends Item {
    public ArrayList<Supplier<EntityType<?>>> types;

    public SpawnDollItem(ArrayList<Supplier<EntityType<?>>> types, Settings settings) {
        super(settings);
        this.types = types;
    }

    public SpawnDollItem(Supplier<EntityType<?>> defaultType, Settings settings) {
        super(settings);
        this.types = new ArrayList<>();
        types.add(defaultType);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!(world instanceof ServerWorld)) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);

            BlockPos blockPos2;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockPos2 = blockPos;
            } else {
                blockPos2 = blockPos.offset(direction);
            }

            int count = itemStack.getCount();
            EntityType<?> entityType2 = this.getEntityType(itemStack.getNbt());
            ITeam team = this.getTeam(itemStack);

            for (int i = 0; i < count; i++) {
                Entity entity = entityType2.spawnFromItemStack((ServerWorld) world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG, false, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP);

                if (entity == null) continue;

                itemStack.decrement(1);
                world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
                world.playSound(context.getPlayer(), blockPos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.f, 1.f);

                if (entity instanceof SoldierDollEntity soldier) {
                    ClayMod.LOGGER.info(team.getTeamName());
                    soldier.setTeam(team);
                }
            }

            return ActionResult.CONSUME;
        }
    }

    public ITeam getTeam(ItemStack stack) {
        Optional<Map.Entry<RegistryKey<ITeam>, ITeam>> teamOptional = TeamRegistry.SOLDIER_TEAMS.entrySet().stream().filter(entry -> stack.isOf(entry.getValue().getTeamItem().getItem())).findFirst();
        return teamOptional.map(Map.Entry::getValue).orElse(CLAY_TEAM.get());
    }

    public EntityType<?> getEntityType(@Nullable NbtCompound nbt) {
        if (types.isEmpty()) return null;

        if (nbt != null && nbt.contains("EntityTag", 10)) {
            NbtCompound nbtCompound = nbt.getCompound("EntityTag");
            if (nbtCompound.contains("id", 8)) {
                return EntityType.get(nbtCompound.getString("id")).orElse(types.get(0).get());
            }
        }

        if (types.size() == 1) return types.get(0).get();

        int selected = Random.createLocal().nextBetween(0, types.size() - 1);
        return types.get(selected).get();
    }
}
