package com.matthewperiut.clay.item.common;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
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
import java.util.Objects;

public class SpawnDollItem extends Item
{
    public ArrayList<EntityType<?>> types;
    public SpawnDollItem(ArrayList<EntityType<?>> types, Settings settings)
    {
        super(settings);
        this.types = types;
    }

    public SpawnDollItem(EntityType<? extends MobEntity> defaultType, Settings settings)
    {
        super(settings);
        this.types = new ArrayList<>();
        types.add(defaultType);
    }

    public ActionResult useOnBlock(ItemUsageContext context)
    {
        World world = context.getWorld();
        if (!(world instanceof ServerWorld))
        {
            return ActionResult.SUCCESS;
        }
        else
        {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);

            BlockPos blockPos2;
            if (blockState.getCollisionShape(world, blockPos).isEmpty())
            {
                blockPos2 = blockPos;
            }
            else
            {
                blockPos2 = blockPos.offset(direction);
            }

            int count = itemStack.getCount();
            for (int i = 0; i < count; i++)
            {
                EntityType<?> entityType2 = this.getEntityType(itemStack.getNbt());
                if (entityType2.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG, false, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP) != null)
                {
                    itemStack.decrement(1);
                    world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
                    world.playSound(context.getPlayer(), blockPos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.f, 1.f);
                }
            }

            return ActionResult.CONSUME;
        }
    }

    public EntityType<?> getEntityType(@Nullable NbtCompound nbt)
    {
        if (types.size() < 1)
            return null;

        if (nbt != null && nbt.contains("EntityTag", 10))
        {
            NbtCompound nbtCompound = nbt.getCompound("EntityTag");
            if (nbtCompound.contains("id", 8))
            {
                return EntityType.get(nbtCompound.getString("id")).orElse(types.get(0));
            }
        }

        if (types.size() == 1)
            return types.get(0);

        int selected = Random.createLocal().nextBetween(0, types.size()-1);
        return types.get(selected);
    }
}
