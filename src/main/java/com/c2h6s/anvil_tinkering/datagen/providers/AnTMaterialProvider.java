package com.c2h6s.anvil_tinkering.datagen.providers;

import com.c2h6s.anvil_tinkering.datagen.data.AnTMaterialIds;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import java.util.concurrent.CompletableFuture;


public class AnTMaterialProvider extends AbstractMaterialDataProvider {
    public AnTMaterialProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        this.addMaterial(AnTMaterialIds.MAGNET,2,1,true);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return super.m_213708_(cachedOutput);
    }

    @Override
    public String getName() {
        return "Anvil Tinkering Material";
    }
}
