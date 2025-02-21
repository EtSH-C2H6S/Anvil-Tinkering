package com.c2h6s.anvil_tinkering.util;

import com.c2h6s.anvil_tinkering.AnvilTinkering;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialVariant;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.MaterialNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class ToolHeatingHelper {
    public static final ResourceLocation LOCATION_HEAT = AnvilTinkering.getNamespacedLocation("heat");
    public static final MaterialVariantId ID_TUNGSTEN = MaterialVariantId.create(MaterialIds.tungsten,"default");
    public static final MaterialVariantId ID_TUNGSTEN_HEATED = MaterialVariantId.create(MaterialIds.tungsten,"heated");
    public static final MaterialVariantId ID_TUNGSTEN_REDHOT = MaterialVariantId.create(MaterialIds.tungsten,"redhot");
    public static final MaterialVariantId ID_TUNGSTEN_GLOWING = MaterialVariantId.create(MaterialIds.tungsten,"glowing");
    public static final MaterialVariantId ID_TUNGSTEN_INCANDESCENT = MaterialVariantId.create(MaterialIds.tungsten,"incandescent");

    public static int getHeatLevel(int heat){
        if (heat>=1024){
            return 4;
        }
        else if (heat>=256){
            return 3;
        }
        else if (heat>=64){
            return 2;
        }
        else if (heat>=16){
            return 1;
        }
        else return 0;
    }
    public static int getHeatLevel(ToolStack tool){
        MaterialNBT materials = tool.getMaterials();
        for (int i =0;i<materials.size();i++){
            MaterialVariant variant = materials.get(i);
            if (variant.matchesVariant(ID_TUNGSTEN)){
                return 0;
            }
            else if (variant.matchesVariant(ID_TUNGSTEN_HEATED)){
                return 1;
            }
            else if (variant.matchesVariant(ID_TUNGSTEN_REDHOT)){
                return 2;
            }
            else if (variant.matchesVariant(ID_TUNGSTEN_GLOWING)){
                return 3;
            }
            else if (variant.matchesVariant(ID_TUNGSTEN_INCANDESCENT)){
                return 4;
            }
        }
        return 0;
    }
    public static int getPersistentHeatLevel(IToolStackView tool){
        int heat = tool.getPersistentData().getInt(LOCATION_HEAT);
        return getHeatLevel(heat);
    }

    public static void setHeat(IToolStackView tool,int heat){
        tool.getPersistentData().putInt(LOCATION_HEAT, heat);
        updateHeatLevel((ToolStack) tool);
    }
    public static void setHeatLevel(IToolStackView tool,int heatLevel){
        switch (heatLevel){
            default -> setHeat(tool,0);
            case 1 -> setHeat(tool,63);
            case 2 -> setHeat(tool,255);
            case 3 -> setHeat(tool,1023);
            case 4 -> setHeat(tool,4095);
        }
    }


    public static void updateHeatLevel(ToolStack tool){
        MaterialNBT materials = tool.getMaterials();
        int heatLevel =Math.min(4,getPersistentHeatLevel(tool));
        for (int i =0;i<materials.size();i++){
            MaterialVariant variant = materials.get(i);
            if (variant.getVariant().getId().getPath().equals("tungsten")&& variant.getVariant().getId().getNamespace().equals("tconstruct")){
                switch (heatLevel){
                    default -> tool.replaceMaterial(i,ID_TUNGSTEN);
                    case 1 -> tool.replaceMaterial(i,ID_TUNGSTEN_HEATED);
                    case 2 -> tool.replaceMaterial(i,ID_TUNGSTEN_REDHOT);
                    case 3 -> tool.replaceMaterial(i,ID_TUNGSTEN_GLOWING);
                    case 4 -> tool.replaceMaterial(i,ID_TUNGSTEN_INCANDESCENT);
                }
            }
        }
    }

}
