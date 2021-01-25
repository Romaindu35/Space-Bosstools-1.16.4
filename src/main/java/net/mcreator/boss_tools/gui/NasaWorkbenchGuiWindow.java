
package net.mcreator.boss_tools.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NasaWorkbenchGuiWindow extends ContainerScreen<NasaWorkbenchGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public NasaWorkbenchGuiWindow(NasaWorkbenchGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 167;
	}
	private static final ResourceLocation texture = new ResourceLocation("boss_tools:textures/nasa_workbench.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkbenchtopnew.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -42, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + -29, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot2.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + -12, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot3.png"));
		this.blit(ms, this.guiLeft + 46, this.guiTop + -12, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot4.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 5, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot5.png"));
		this.blit(ms, this.guiLeft + 46, this.guiTop + 5, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkbenchguinormal.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 38, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot6.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 22, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot7.png"));
		this.blit(ms, this.guiLeft + 46, this.guiTop + 22, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot8.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 39, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot9.png"));
		this.blit(ms, this.guiLeft + 46, this.guiTop + 39, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot10.png"));
		this.blit(ms, this.guiLeft + 12, this.guiTop + 39, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot11.png"));
		this.blit(ms, this.guiLeft + 12, this.guiTop + 56, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot12.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 56, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot13.png"));
		this.blit(ms, this.guiLeft + 63, this.guiTop + 39, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkslot14.png"));
		this.blit(ms, this.guiLeft + 63, this.guiTop + 56, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture1.png"));
		this.blit(ms, this.guiLeft + 54, this.guiTop + 58, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture2.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 57, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture3.png"));
		this.blit(ms, this.guiLeft + 80, this.guiTop + 57, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture4.png"));
		this.blit(ms, this.guiLeft + 63, this.guiTop + 73, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture5.png"));
		this.blit(ms, this.guiLeft + 37, this.guiTop + 73, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture6.png"));
		this.blit(ms, this.guiLeft + 12, this.guiTop + 73, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworkbenchoutput.png"));
		this.blit(ms, this.guiLeft + 123, this.guiTop + 35, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture7.png"));
		this.blit(ms, this.guiLeft + 26, this.guiTop + 73, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasapfeil.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 17, 0, 0, 256, 256, 256, 256);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/nasaworktexture7.png"));
		this.blit(ms, this.guiLeft + 79, this.guiTop + 73, 0, 0, 256, 256, 256, 256);
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
		this.font.drawString(ms, "NASA Workbench", 4, -38, -13421773);
		this.font.drawString(ms, "Inventory", 7, 74, -13421773);
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
	}
}
