
package pl.diratix.advancedbrewerysystem.itemgroup;

import pl.diratix.advancedbrewerysystem.item.AdvancedbrewerylogoItem;
import pl.diratix.advancedbrewerysystem.AdvancedBrewerySystemModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AdvancedBrewerySystemModElements.ModElement.Tag
public class AdvancedBreverySystemItemGroup extends AdvancedBrewerySystemModElements.ModElement {
	public AdvancedBreverySystemItemGroup(AdvancedBrewerySystemModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabadvanced_brevery_system") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AdvancedbrewerylogoItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
