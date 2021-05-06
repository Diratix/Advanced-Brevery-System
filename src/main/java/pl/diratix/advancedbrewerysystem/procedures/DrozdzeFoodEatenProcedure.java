package pl.diratix.advancedbrewerysystem.procedures;

import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemModElements;
import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class DrozdzeFoodEatenProcedure extends AdvancedBrewerySystemModElements.ModElement {
	public DrozdzeFoodEatenProcedure(AdvancedBrewerySystemModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedBrewerySystemMod.LOGGER.warn("Failed to load dependency entity for procedure DrozdzeFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 60, (int) 1));
	}
}
