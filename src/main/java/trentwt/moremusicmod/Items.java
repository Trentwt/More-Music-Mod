package trentwt.moremusicmod;

import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import trentwt.moremusicmod.utils.StringUtils;

public class Items {

	public static Item blank_record;

	
	public static void init() {
		blank_record = new Item().setUnlocalizedName("blank_record").setCreativeTab(MoreMusicMod.tabMoreMusicMod);
	}
	
	public static void register() {
		GameRegistry.registerItem(blank_record, blank_record.getUnlocalizedName().substring(5));
	}
	
	public static void registerItemRenders() throws Exception{
		for (Field f : Items.class.getDeclaredFields()) {
			if (f.getType() == Item.class) {
				registerItemRender((Item) f.get(null));
			}
		}
	}
	
	public static void registerItemRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(StringUtils.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
