
package net.mcreator.boss_tools.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.boss_tools.BossToolsMod;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RocketGuiTier3GuiWindow extends ContainerScreen<RocketGuiTier3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public RocketGuiTier3GuiWindow(RocketGuiTier3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 255;
		this.ySize = 170;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/guirockettier1newguinew.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/overworldbild.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 13, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/moonbild.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 51, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/marsbild.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 89, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/mercury_icon.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 126, 0, 0, 32, 31, 32, 31);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 19, 36, 20, new StringTextComponent("Orbit"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(0, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 0, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 57, 36, 20, new StringTextComponent("Orbit"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(1, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 1, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 95, 36, 20, new StringTextComponent("Orbit"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(2, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 2, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 132, 36, 20, new StringTextComponent("Orbit"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(3, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 3, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 19, 75, 20, new StringTextComponent("Overworld"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(4, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 4, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 19, 79, 20, new StringTextComponent("Space Station"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(5, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 5, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 57, 75, 20, new StringTextComponent("Moon"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(6, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 6, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 57, 79, 20, new StringTextComponent("Space Station"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(7, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 7, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 95, 75, 20, new StringTextComponent("Mars"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(8, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 8, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 95, 79, 20, new StringTextComponent("Space Station"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(9, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 9, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 132, 75, 20, new StringTextComponent("Mercury"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(10, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 10, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 132, 79, 20, new StringTextComponent("Space Station"), e -> {
			BossToolsMod.PACKET_HANDLER.sendToServer(new RocketGuiTier3Gui.ButtonPressedMessage(11, x, y, z));
			RocketGuiTier3Gui.handleButtonAction(entity, 11, x, y, z);
		}));
	}
}
