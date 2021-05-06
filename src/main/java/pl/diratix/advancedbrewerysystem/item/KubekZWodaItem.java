
package pl.diratix.advancedbrewerysystem.item;

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
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class KubekZWodaItem extends AdvancedBrewerySystemModElements.ModElement {
	@ObjectHolder("advanced_brewery_system:kubek_z_woda")
	public static final Item block = null;
	public KubekZWodaItem(AdvancedBrewerySystemModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AdvancedBreverySystemItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("kubek_z_woda");
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
			list.add(new StringTextComponent("Poprostu kubek wype\u0142niony wod\u0105 ;)"));
		}
	}
}
