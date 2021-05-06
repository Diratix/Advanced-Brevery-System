
package pl.diratix.advancedbrewerysystem.item;

import pl.diratix.advancedbrewerysystem.procedures.SfermentowanynapojFoodEatenProcedure;
import pl.diratix.advancedbrewerysystem.itemgroup.AdvancedBreverySystemItemGroup;
import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class SfermentowanynapojItem extends AdvancedBrewerySystemModElements.ModElement {
	@ObjectHolder("advanced_brewery_system:sfermentowanynapoj")
	public static final Item block = null;
	public SfermentowanynapojItem(AdvancedBrewerySystemModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AdvancedBreverySystemItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("sfermentowanynapoj");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Sfermentowany nap\u00F3j mo\u017Ce pos\u0142u\u017Cy\u0107 jako baza pod r\u00F3\u017Cne trunki"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SfermentowanynapojFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
