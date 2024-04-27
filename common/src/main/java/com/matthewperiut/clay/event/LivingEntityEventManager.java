package com.matthewperiut.clay.event;

import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import com.matthewperiut.clay.upgrade.UpgradeManager;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class LivingEntityEventManager {

    public static void register() {
        EntityEvent.LIVING_DEATH.register((LivingEntity dyingEntity, DamageSource source) -> {
            if (dyingEntity instanceof SoldierDollEntity dyingSoldier && source.getAttacker() instanceof SoldierDollEntity attackingSoldier) {
                for (ISoldierUpgrade upgrade : attackingSoldier.upgrades) {
                    upgrade.onKill(dyingSoldier, attackingSoldier);
                }
                ISoldierUpgrade upgrade;
                while ((upgrade = attackingSoldier.removeUpgrades.poll()) != null) {
                    UpgradeManager.INSTANCE.removeUpgrade(attackingSoldier, upgrade);
                }
            }
            return EventResult.pass();
        });
    }
}
