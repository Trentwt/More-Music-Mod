package trentwt.moremusicmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import trentwt.moremusicmod.ModItems;
import trentwt.moremusicmod.MoreMusicMod;
import trentwt.moremusicmod.blocks.DiskWriterBlock;

public class BlankDisc extends Item {

	public BlankDisc() {
		this.setCreativeTab(MoreMusicMod.tabMoreMusicMod);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if (world.getBlockState(pos).getBlock() instanceof DiskWriterBlock) {
			try {
				player.inventory.mainInventory[player.inventory.currentItem].setItem(ModItems.record_written);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
}
