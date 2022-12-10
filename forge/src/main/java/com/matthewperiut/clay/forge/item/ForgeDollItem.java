package com.matthewperiut.clay.forge.item;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.item.common.DollDispenserBehavior;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
//1.18 import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ForgeDollItem extends Item {
    public static final DispenserBehavior dollDispenserBehavior = new DollDispenserBehavior();
    private static final List<ForgeDollItem> colored_dolls = new ArrayList<>();
    public static final List<ForgeDollItem> dolls = new ArrayList<>();
    int color;
    public ArrayList<Supplier<EntityType<?>>> types;

    public ForgeDollItem(ArrayList<Supplier<EntityType<?>>> types, Settings settings, int color) {
        super(settings);
        this.types = types;
        this.color = color;
        colored_dolls.add(this);
        dolls.add(this);
    }

    public ForgeDollItem(Supplier<EntityType<?>> defaultType, Settings settings, int color) {
        super(settings);
        this.types = new ArrayList<>();
        types.add(defaultType);
        this.color = color;
        colored_dolls.add(this);
        dolls.add(this);
    }

    public ForgeDollItem(Supplier<EntityType<?>> defaultType, Settings settings) {
        super(settings);
        this.types = new ArrayList<>();
        types.add(defaultType);
        dolls.add(this);
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
            for (int i = 0; i < count; i++) {
                EntityType<?> entityType2 = this.getEntityType(itemStack.getNbt());
                if (entityType2.spawnFromItemStack((ServerWorld) world, itemStack, context.getPlayer(), blockPos2, SpawnReason.SPAWN_EGG, false, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP) != null) {
                    itemStack.decrement(1);
                    //world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
                    world.playSound(context.getPlayer(), blockPos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.f, 1.f);
                }
            }

            return ActionResult.CONSUME;
        }
    }

    public EntityType<?> getEntityType(@Nullable NbtCompound nbt) {
        if (types.size() < 1)
            return null;

        if (nbt != null && nbt.contains("EntityTag", 10)) {
            NbtCompound nbtCompound = nbt.getCompound("EntityTag");
            if (nbtCompound.contains("id", 8)) {
                return EntityType.get(nbtCompound.getString("id")).orElse(types.get(0).get());
            }
        }

        if (types.size() == 1)
            return types.get(0).get();

        int selected = ClayMod.random.nextInt(0, types.size() - 1);
        return types.get(selected).get();
    }

    @Nullable
    protected DispenserBehavior createDispenseBehavior()
    {
        return dollDispenserBehavior;
    }

    @Mod.EventBusSubscriber(modid = ClayMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class CommonHandler
    {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event)
        {
            dolls.forEach(doll ->
            {
                DispenserBehavior dispenseBehavior = doll.createDispenseBehavior();
                if (dispenseBehavior != null)
                {
                    DispenserBlock.registerBehavior(doll, dispenseBehavior);
                }
            });
        }
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ClayMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        /* 1.18
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerItemColors(ColorHandlerEvent.Item event)
        {
            for (ForgeDollItem doll : colored_dolls)
            {
                event.getItemColors().register((stack, tintIndex) -> doll.color, doll);
            }
        }*/
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerItemColors(RegisterColorHandlersEvent.Item event)
        {
            for (ForgeDollItem doll : colored_dolls)
            {
                event.register((stack, tintIndex) -> doll.color, doll);
            }
        }
    }
}
