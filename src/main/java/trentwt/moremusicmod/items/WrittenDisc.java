package trentwt.moremusicmod.items;

import java.util.ArrayList;
import java.util.List;

import scala.actors.threadpool.Arrays;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WrittenDisc extends Item {
	
	public static final String[] musics = {"13", "cat", "blocks", "chirp", "far", "mall", "mellohi", "stal", "strad", "ward", "11", "wait"};
	
	public WrittenDisc() {
		
	}
	
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (stack.getTagCompound() != null) {
			playerIn.inventory.addItemStackToInventory(new ItemStack((Item) Item.itemRegistry.getObject(new ResourceLocation("record_" + stack.getTagCompound().getString("musicdata")))));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bool) {
		if (itemStack.getTagCompound() != null) {
			NBTTagCompound nbt = itemStack.getTagCompound();
			String song = nbt.getString("musicdata").substring(0, 1).toUpperCase() + nbt.getString("musicdata").substring(1);
			list.add("Song: " + song);
		}
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (stack.getTagCompound() == null) return false;

		try {
			player.inventory.mainInventory[player.inventory.currentItem] = new ItemStack((Item) Item.itemRegistry.getObject(new ResourceLocation("record_" + stack.getTagCompound().getString("musicdata"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
