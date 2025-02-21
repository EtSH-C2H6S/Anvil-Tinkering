package com.c2h6s.anvil_tinkering.tinkering.modifiers.base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.DamageBlockModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierRemovalHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

public class AnTBaseModifier extends Modifier implements MeleeHitModifierHook, MeleeDamageModifierHook, ProjectileLaunchModifierHook, ProjectileHitModifierHook,OnAttackedModifierHook, DamageBlockModifierHook, ToolDamageModifierHook, BlockBreakModifierHook, ModifierRemovalHook, InventoryTickModifierHook, EquipmentChangeModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.ON_ATTACKED,ModifierHooks.REMOVE,ModifierHooks.DAMAGE_BLOCK,ModifierHooks.INVENTORY_TICK,ModifierHooks.MELEE_DAMAGE,ModifierHooks.MELEE_HIT,ModifierHooks.PROJECTILE_HIT,ModifierHooks.PROJECTILE_LAUNCH,ModifierHooks.BLOCK_BREAK,ModifierHooks.EQUIPMENT_CHANGE,ModifierHooks.TOOL_DAMAGE);
    }

    public boolean isNoLevels(){
        return false;
    }
    @Override
    public Component getDisplayName(int level) {
        return this.isNoLevels()?super.getDisplayName():super.getDisplayName(level);
    }

    @Override
    public boolean isDamageBlocked(IToolStackView iToolStackView, ModifierEntry modifierEntry, EquipmentContext equipmentContext, EquipmentSlot equipmentSlot, DamageSource damageSource, float v) {
        return this.BlockDamage(iToolStackView,modifierEntry,equipmentContext,equipmentSlot,damageSource,v);
    }
    @Override
    public void onAttacked(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource damageSource, float amount, boolean directDamage) {
        this.ProcessAttack(tool,modifier,context,slot,damageSource,amount,directDamage);
    }
    @Override
    public int onDamageTool(IToolStackView iToolStackView, ModifierEntry modifierEntry, int i, @Nullable LivingEntity livingEntity) {
        return this.ModifyToolDamage(iToolStackView,modifierEntry,i,livingEntity);
    }
    @Nullable
    @Override
    public Component onRemoved(IToolStackView iToolStackView, Modifier modifier) {
        return this.HandleRemoval(iToolStackView,modifier);
    }
    @Override
    public float getMeleeDamage(IToolStackView iToolStackView, ModifierEntry modifierEntry, ToolAttackContext toolAttackContext, float v, float v1) {
        return this.ModifyMeleeDamage(iToolStackView,modifierEntry,toolAttackContext,v,v1);
    }
    @Override
    public void afterBlockBreak(IToolStackView iToolStackView, ModifierEntry modifierEntry, ToolHarvestContext toolHarvestContext) {
        this.ModifyAfterBlockBreak(iToolStackView,modifierEntry,toolHarvestContext);
    }
    @Override
    public void onProjectileLaunch(IToolStackView iToolStackView, ModifierEntry modifierEntry, LivingEntity livingEntity, Projectile projectile, @Nullable AbstractArrow abstractArrow, ModDataNBT modDataNBT, boolean b) {
        this.ModifyProjectileLaunch(iToolStackView,modifierEntry,livingEntity,projectile,abstractArrow,modDataNBT,b);
    }
    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        this.HandleInventoryTick(tool,modifier,world,holder,itemSlot,isSelected,isCorrectSlot,stack);
    }

    public boolean BlockDamage(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource damageSource, float amount){
        return false;
    }
    public void ProcessAttack(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slot, DamageSource damageSource, float amount, boolean directDamage) {

    }
    public int ModifyToolDamage(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity livingEntity) {
        return amount;
    }
    public Component HandleRemoval(IToolStackView tool, Modifier modifier) {
        return null;
    }
    public float ModifyMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        return damage;
    }
    public void ModifyAfterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {

    }
    public void ModifyProjectileLaunch(IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile, @Nullable AbstractArrow abstractArrow, ModDataNBT modDataNBT, boolean primary) {

    }
    public void HandleInventoryTick(IToolStackView tool, ModifierEntry modifier, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {

    }

}
