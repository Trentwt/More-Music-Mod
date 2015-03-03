package trentwt.moremusicmod;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trentwt.moremusicmod.items.BlankDisc;
import trentwt.moremusicmod.items.WrittenDisc;
import trentwt.moremusicmod.utils.StringUtils;

public class ModItems {

	public static Item record_blank;
	
	public static Item record_written;

	public static void init() {
		record_blank = new BlankDisc().setUnlocalizedName("record_blank");
		
		record_written = new WrittenDisc().setUnlocalizedName("record_written");
	}
	
	public static void register() {
		GameRegistry.registerItem(record_blank, record_blank.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(record_written, record_written.getUnlocalizedName().substring(5));
	}
	
	public static void registerItemRenders() throws Exception {
		for (Field f : ModItems.class.getDeclaredFields()) {
			if (f.getType() == Item.class) {
				registerItemRender((Item) f.get(null));
			}
		}
	}
	
	public static void registerItemRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(StringUtils.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
