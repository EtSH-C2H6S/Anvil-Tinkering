package com.c2h6s.anvil_tinkering.register;

import com.c2h6s.anvil_tinkering.AnvilTinkering;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;

public class AnTItems {
    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(AnvilTinkering.MODID);

    public static final CastItemObject PRESSURE_PLATE_CAST = ITEMS.registerCast("pressure_plate",new Item.Properties());
}
