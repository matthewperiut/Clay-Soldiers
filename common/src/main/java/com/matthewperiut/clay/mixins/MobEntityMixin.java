package com.matthewperiut.clay.mixins;

import com.matthewperiut.clay.extensions.ISpawnReasonExtension;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// TODO add NBT Data to save spawn reason on world close
// writeCustomDataToNbt
// readCustomDataFromNbt
@Mixin(MobEntity.class)
public class MobEntityMixin implements ISpawnReasonExtension {

    @Unique
    private SpawnReason clay$spawnReason;

    @Inject(method = "initialize", at = @At("TAIL"))
    private void initializeMixin(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        this.clay$spawnReason = spawnReason;
    }

    @Override
    public SpawnReason clay$getSpawnReason() {
        return this.clay$spawnReason;
    }
}
