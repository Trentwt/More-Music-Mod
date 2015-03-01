package trentwt.moremusicmod;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trentwt.moremusicmod.blocks.DiskWriterBlock;
import trentwt.moremusicmod.blocks.IARDBlock;
import trentwt.moremusicmod.blocks.MStorageBlock;
import trentwt.moremusicmod.utils.StringUtils;

public class ModBlocks {
	public static Block iard_block;
	public static Block mstorage_block;
	public static Block disc_writer_block;
	public static Block disc_writer_block_active;
	
	private static Boolean isWriting;
	
	public static void init() {
		iard_block = new IARDBlock().setUnlocalizedName("iard_block");
		mstorage_block = new MStorageBlock().setUnlocalizedName("mstorage_block");
		disc_writer_block = new DiskWriterBlock(false).setUnlocalizedName("disc_writer_block");
		disc_writer_block_active = new DiskWriterBlock(true).setUnlocalizedName("disc_writer_block_active");
	}
	
	public static void register() {
		GameRegistry.registerBlock(iard_block, iard_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(mstorage_block, mstorage_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(disc_writer_block, disc_writer_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(disc_writer_block_active, disc_writer_block_active.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlockRenders() throws Exception {
		for (Field f : ModBlocks.class.getDeclaredFields()) {
			if (f.getType() == Block.class) {
				registerBlockRender((Block) f.get(null));
			}
		}
	}
	
	public static void registerBlockRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(StringUtils.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
