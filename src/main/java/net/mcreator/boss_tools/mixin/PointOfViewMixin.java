package net.mcreator.boss_tools.mixin;

import net.mcreator.boss_tools.BossToolsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PointOfView.class)
public class PointOfViewMixin {

    @Inject(at = @At("HEAD"), method = "func_243194_c", cancellable = true)
    public void func_243194_c(CallbackInfoReturnable<PointOfView> cir) {
        if (Minecraft.getInstance().player.getPersistentData().contains("isInRocket")) {
            boolean isInRocket = Minecraft.getInstance().player.getPersistentData().getBoolean("isInRocket");
            if (isInRocket) {
                cir.setReturnValue(PointOfView.THIRD_PERSON_FRONT);
            }
        }
        //if (BossToolsMod.IsInRocket)
            //cir.setReturnValue(PointOfView.THIRD_PERSON_BACK);
    }

}
