package com.matthewperiut.clay.entity.soldier.variant;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class BlackSoldierDoll extends SoldierDollEntity
{
    public static final Identifier TEXTURE_ID = Identifier.of(ClayMod.MOD_ID, "textures/entity/soldier/black.png");

    public BlackSoldierDoll(EntityType<? extends PathAwareEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
