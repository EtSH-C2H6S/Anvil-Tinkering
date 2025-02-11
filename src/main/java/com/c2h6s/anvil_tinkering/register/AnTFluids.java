package com.c2h6s.anvil_tinkering.register;

import com.c2h6s.anvil_tinkering.AnvilTinkering;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.TConstruct;

import static slimeknights.tconstruct.fluids.block.BurningLiquidBlock.createBurning;

public class AnTFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(AnvilTinkering.MODID);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ROYAL_STEEL = FLUIDS.register("molten_royal_steel").type(hot("molten_royal_steel")).bucket().block(createBurning(MapColor.COLOR_GRAY,15,8,1f)).commonTag().flowing();
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_FERRITE = FLUIDS.register("molten_ferrite").type(cool("molten_ferrite")).bucket().block(MapColor.COLOR_BLACK,0).commonTag().flowing();

    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(makeFluidDescriptionId(name))
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
    private static FluidType.Properties cool(String name) {
        return FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .motionScale(0.0023333333333333335).canExtinguish(true)
                .descriptionId(makeFluidDescriptionId(name));
    }

    public static String makeFluidDescriptionId(String name){
        return "fluid."+AnvilTinkering.MODID+"."+name;
    }
}
