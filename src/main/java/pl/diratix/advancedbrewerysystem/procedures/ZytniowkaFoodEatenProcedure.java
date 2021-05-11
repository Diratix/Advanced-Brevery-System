package pl.diratix.advancedbrewerysystem.procedures;

import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemModElements;
import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class ZytniowkaFoodEatenProcedure extends AdvancedBrewerySystemModElements.ModElement {
	public ZytniowkaFoodEatenProcedure(AdvancedBrewerySystemModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AdvancedBrewerySystemMod.LOGGER.warn("Failed to load dependency entity for procedure ZytniowkaFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 1500, (int) 1));
	}
}
