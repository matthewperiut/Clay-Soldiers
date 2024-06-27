package com.matthewperiut.clay.item.disruptor;

import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicBoolean;

public class DisruptorDispenserBehavior extends FallibleItemDispenserBehavior
{
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack)
    {
        World world = pointer.world();

        if (world.isClient()) {
            return stack;
        }

        Item item = stack.getItem();

        if (item instanceof DisruptorItem disruptor) {
            this.setSuccess(disruptor.killClayEntity(world, Vec3d.ofCenter(pointer.pos())));
            if (this.isSuccess()) {
                if (!disruptor.unlimited) {
                    stack.damage(1, world.getRandom(), (ServerPlayerEntity)null, () -> {
                        stack.setCount(0);
                    });
                }
            }
        }

        return stack;
    }
}
