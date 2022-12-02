package com.matthewperiut.clay.item.common;

import net.minecraft.block.BlockState;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.event.GameEvent;

public class DollDispenserBehavior implements DispenserBehavior
{
    @Override
    public ItemStack dispense(BlockPointer pointer, ItemStack stack)
    {
        if (stack.getItem() instanceof SpawnDollItem)
        {
            ServerWorld world = (ServerWorld)pointer.getWorld();
            BlockPos pos = pointer.getPos();
            DispenserBlockEntity dispenserEntity = pointer.getBlockEntity();
            BlockState dispenserBlock = world.getBlockState(dispenserEntity.getPos());
            SpawnDollItem doll = (SpawnDollItem) stack.getItem();
            Direction direction = dispenserBlock.get(Properties.FACING);
            BlockPos spawnPos = pos.add(new Vec3i(direction.getOffsetX(), direction.getOffsetY(), direction.getOffsetZ()));

            EntityType<?> entityType = doll.getEntityType(stack.getNbt());
            Entity e = entityType.spawnFromItemStack(world, stack, null, spawnPos, SpawnReason.DISPENSER, false, false);
            if (e != null)
            {
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.emitGameEvent(GameEvent.ENTITY_PLACE, spawnPos, GameEvent.Emitter.of(e));
                stack.setCount(stack.getCount()-1);
            }
        }

        return stack;
    }
}
