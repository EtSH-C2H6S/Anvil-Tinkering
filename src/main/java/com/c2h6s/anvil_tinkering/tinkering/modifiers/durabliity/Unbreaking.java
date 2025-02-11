package com.c2h6s.anvil_tinkering.tinkering.modifiers.durabliity;

import com.c2h6s.anvil_tinkering.tinkering.modifiers.base.AnTBaseModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class Unbreaking extends AnTBaseModifier {
    @Override
    public Component getDisplayName(int level) {
        return level<=3?super.getDisplayName(level):super.getDisplayName(3);
    }

    @Override
    public int ModifyToolDamage(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity livingEntity) {
        int efficientLevel = Math.min(3,modifier.getLevel());
        if (RANDOM.nextInt(100)>100/efficientLevel+1){
            return 0;
        }
        return amount;
    }
}
