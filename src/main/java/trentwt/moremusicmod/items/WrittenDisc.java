package trentwt.moremusicmod.items;

import trentwt.moremusicmod.MoreMusicMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WrittenDisc extends Item {

	public WrittenDisc() {
		this.setCreativeTab(MoreMusicMod.tabMoreMusicMod);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
}
