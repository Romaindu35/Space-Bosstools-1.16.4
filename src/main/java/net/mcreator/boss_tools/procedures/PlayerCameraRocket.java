package net.mcreator.boss_tools.procedures;

import com.mrcrayfish.obfuscate.client.event.PlayerModelEvent;
import net.mcreator.boss_tools.BossToolsModElements;
import net.mcreator.boss_tools.entity.RocketEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@BossToolsModElements.ModElement.Tag
public class PlayerCameraRocket extends BossToolsModElements.ModElement {

    public PlayerCameraRocket(BossToolsModElements elements) {
        super(elements, 600);
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("EventFOVRegister");
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void setupFOVPlayer(EntityViewRenderEvent.FOVModifier event) {
        if (Minecraft.getInstance().player.getPersistentData().contains("isInRocket")) {
            boolean isInRocket = Minecraft.getInstance().player.getPersistentData().getBoolean("isInRocket");
            if (isInRocket) {
                event.setFOV(70 + 35);
            } else {
                event.setFOV(70);
            }
        }
    }

}
