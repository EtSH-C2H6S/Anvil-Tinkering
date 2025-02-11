package com.c2h6s.anvil_tinkering.tinkering.modifiers.common;

import com.c2h6s.anvil_tinkering.tinkering.modifiers.base.AnTBaseModifier;
import dev.dubhe.anvilcraft.init.ModBlocks;
import dev.dubhe.anvilcraft.init.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class Magnetizing extends AnTBaseModifier implements ProcessLootModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.PROCESS_LOOT);
    }

    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> list, LootContext lootContext) {
        if (RANDOM.nextInt(50)<modifier.getLevel()){
            for (int i =0;i<list.size();i++){
                ItemStack stack = list.get(i);
                if (stack.is(Items.IRON_INGOT)){
                    list.set(i,new ItemStack(ModItems.MAGNET_INGOT.get(),stack.getCount()));
                }
                if (stack.is(Items.IRON_BLOCK)){
                    list.set(i,new ItemStack(ModBlocks.MAGNET_BLOCK.get(),stack.getCount()));
                }
            }
        }
    }
}
