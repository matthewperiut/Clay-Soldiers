package com.matthewperiut.clay.item.disruptor;

import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DisruptorDispenserBehavior extends FallibleItemDispenserBehavior
{
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack)
    {
        World world = pointer.getWorld();

        if (world.isClient()) {
            return stack;
        }

        Item item = stack.getItem();

        if (item instanceof DisruptorItem disruptor) {
            this.setSuccess(disruptor.killClayEntity(world, Vec3d.ofCenter(pointer.getPos())));
            if (this.isSuccess()) {
                if (!disruptor.unlimited) {
                    if (stack.damage(1, world.getRandom(), null)) {
                        stack.setCount(0);
                    }
                }
            }
        }

        return stack;
    }
}
