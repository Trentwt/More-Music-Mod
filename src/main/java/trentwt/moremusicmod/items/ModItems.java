package trentwt.moremusicmod.items;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trentwt.moremusicmod.utils.StringUtils;

public class ModItems {

	public static Item record_blank;

	public static void init() {
		record_blank = new BlankDisc().setUnlocalizedName("record_blank");
	}
	
	public static void register() {
		GameRegistry.registerItem(record_blank, record_blank.getUnlocalizedName().substring(5));
	}
	
	public static void registerItemRenders() throws Exception {
		for (Field f : ModItems.class.getDeclaredFields()) {
			if (f.getType() == Item.class) {
				registerItemRender((Item) f.get(null));
				Logger.getLogger("Minecraft").info(((Item)f.get(null)).getUnlocalizedName());
			}
		}
		Logger.getLogger("Minecraft").info("registerrenders called! :D");
	}
	
	public static void registerItemRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(StringUtils.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
