package com.matthewperiut.clay.item.disruptor;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class DisruptorItem extends ToolItem
{
    public DisruptorItem(ToolMaterial material, Settings settings)
    {
        super(material, settings);
    }

    boolean unlimited = false;

    public DisruptorItem(Settings settings)
    {
        super(new ClayMaterial(), settings);
        unlimited = true;
    }

    public boolean killClayEntity(World world, Vec3d pos)
    {
        Box area = new Box(pos.subtract(new Vec3d(16, 16, 16)), pos.add(new Vec3d(16, 16, 16)));
        List<Entity> entityList = world.getOtherEntities(null, area);

        boolean found = false;
        for (Entity entity : entityList)
        {
            if (entity instanceof SoldierDollEntity || entity instanceof HorseDollEntity)
            {
                entity.kill();
                found = true;
            }
        }

        return found;
    }

    public boolean removeClayEntity(World world, Entity user, ItemStack stack)
    {
        boolean found = killClayEntity(world, user.getPos());

        if (found)
        {
            if (!unlimited)
            {
                stack.damage(1, world.random, (ServerPlayerEntity) null, () -> {
                    stack.setCount(0);
                });

                return true;
            }

            if (user instanceof PlayerEntity)
            {
                ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
                return true;
            }
            else
            {
                PlayerEntity player = (PlayerEntity) user;
                if (!unlimited) {
                    stack.damage(1, world.random, (ServerPlayerEntity) null, () -> {
                                        ((PlayerEntity) user).getItemCooldownManager().set(this, 20);

                        stack.setCount(0);
                    });
                }


                return true;
            }
        }
        return false;
    }

    public boolean removeClayBlock(World world, Entity user, ItemStack stack)
    {
        Vec3d pos = user.getPos();
        Box area = new Box(pos.subtract(new Vec3d(16, 16, 16)), pos.add(new Vec3d(16, 16, 16)));
        boolean found = false;

        for (int x = (int) area.minX; x <= (int) area.maxX; x++)
        {
            for (int y = (int) area.minY; y <= (int) area.maxY; y++)
            {
                for (int z = (int) area.minZ; z <= (int) area.maxZ; z++)
                {
                    BlockPos blockPos = new BlockPos(x, y, z);
                    BlockState blockState = world.getBlockState(blockPos);

                    if (blockState.getBlock().getDefaultState().equals(Blocks.CLAY.getDefaultState()))
                    {
                        world.breakBlock(blockPos, true);
                        found = true;
                    }
                }
            }
        }

        if (found)
        {
            if (!unlimited)
            {
                    stack.damage(1, world.random, (ServerPlayerEntity) null, () -> {
                                        ((PlayerEntity) user).getItemCooldownManager().set(this, 20);


                        stack.setCount(0);
                    });
                    return true;
            }

            if (user instanceof PlayerEntity)
            {
                ((PlayerEntity) user).getItemCooldownManager().set(this, 20);
                return true;
            }
            else
            {
                stack.damage(1, world.random, (ServerPlayerEntity) null, () -> {
                    stack.setCount(0);
                });
                return true;
            }
        }
        return false;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);

        if (removeClayEntity(world, user, itemStack) || removeClayBlock(world, user, itemStack))
            return TypedActionResult.consume(itemStack);

        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.clay.disruptor.range").formatted(Formatting.GRAY));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
