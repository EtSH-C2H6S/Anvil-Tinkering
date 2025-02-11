package com.c2h6s.anvil_tinkering.register;

import com.c2h6s.anvil_tinkering.AnvilTinkering;
import com.c2h6s.anvil_tinkering.tinkering.modifiers.common.Magnetizing;
import com.c2h6s.anvil_tinkering.tinkering.modifiers.durabliity.Unbreaking;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class AnTModifiers {
    public static final ModifierDeferredRegister MODIFIER = ModifierDeferredRegister.create(AnvilTinkering.MODID);

    public static final StaticModifier<Magnetizing> MAGNETIZING = MODIFIER.register("magnetizing",Magnetizing::new);
    public static final StaticModifier<Unbreaking> UNBREAKING = MODIFIER.register("unbreaking",Unbreaking::new);
}
