package com.c2h6s.anvil_tinkering.datagen.data;

import com.c2h6s.anvil_tinkering.AnvilTinkering;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class AnTMaterialIds {
    public static final MaterialId MAGNET = material("magnet");

    public static MaterialId material(String name){
        return new MaterialId(AnvilTinkering.getNamespacedLocation(name));
    }
}
