package trentwt.moremusicmod.blocks;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trentwt.moremusicmod.items.ModItems;
import trentwt.moremusicmod.utils.StringUtils;

public class ModBlocks {
	public static Block iard_block;
	
	public static void init() {
		iard_block = new IARDBlock().setUnlocalizedName("iard_block");
	}
	
	public static void register() {
		GameRegistry.registerBlock(iard_block, iard_block.getUnlocalizedName().substring(5));
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
