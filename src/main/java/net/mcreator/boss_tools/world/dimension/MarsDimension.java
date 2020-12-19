
package net.mcreator.boss_tools.world.dimension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.block.Block;

import net.mcreator.boss_tools.procedures.MoonPlayerLeavesDimensionProcedure;
import net.mcreator.boss_tools.procedures.MoonPlayerEntersDimensionProcedure;
import net.mcreator.boss_tools.block.MarsStoneBlock;
import net.mcreator.boss_tools.BossToolsModElements;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

import com.google.common.collect.ImmutableSet;

@BossToolsModElements.ModElement.Tag
public class MarsDimension extends BossToolsModElements.ModElement {
	public MarsDimension(BossToolsModElements instance) {
		super(instance, 73);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.add(MarsStoneBlock.block.getDefaultState().getBlock()).build(), "field_222718_j");
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.add(MarsStoneBlock.block.getDefaultState().getBlock()).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(Float.NaN, true, DimensionRenderInfo.FogType.NONE, false, false) {
			@Override
			public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
				return new Vector3d(1, 0.6, 0);
			}

			@Override
			public boolean func_230493_a_(int x, int y) {
				return false;
			}
		};
		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper
						.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("boss_tools:mars"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getPlayer();
		World world = entity.world;
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		if (event.getFrom() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:mars"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MoonPlayerLeavesDimensionProcedure.executeProcedure($_dependencies);
			}
		}
		if (event.getTo() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:mars"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MoonPlayerEntersDimensionProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
