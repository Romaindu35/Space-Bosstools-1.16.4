package net.mcreator.boss_tools.procedures;

import net.mcreator.boss_tools.BossToolsModVariables;
import net.mcreator.boss_tools.BossToolsModElements;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class AlienVillageAdditionalGenerationConditionProcedure extends BossToolsModElements.ModElement {
	public AlienVillageAdditionalGenerationConditionProcedure(BossToolsModElements instance) {
		super(instance, 531);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		return ((BossToolsModVariables.Configalienhouse) == 1);
	}
}
