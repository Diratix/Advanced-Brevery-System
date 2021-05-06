
package pl.diratix.advancedbrewerysystem.item;

import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class AdvancedbrewerylogoItem extends AdvancedBrewerySystemModElements.ModElement {
	@ObjectHolder("advanced_brewery_system:advancedbrewerylogo")
	public static final Item block = null;
	public AdvancedbrewerylogoItem(AdvancedBrewerySystemModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("advancedbrewerylogo");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
