package trentwt.moremusicmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trentwt.moremusicmod.proxy.CommonProxy;
import trentwt.moremusicmod.utils.StringUtils;

@Mod(modid = StringUtils.MOD_ID, name = StringUtils.MOD_NAME, version = StringUtils.MOD_VERSION)
public class MoreMusicMod {
	
	@SidedProxy(clientSide = StringUtils.CLIENT_PROXY_CLASS, serverSide = StringUtils.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
	}
	
	@EventHandler
	public void initialization(FMLInitializationEvent event) {
		proxy.registerRenders();
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.iard_block), "nin", "dmd", "nin",
				'n', new ItemStack(Blocks.noteblock),
				'i', new ItemStack(Items.iron_ingot),
				'd', new ItemStack(Items.diamond),
				'm', new ItemStack(ModBlocks.mstorage_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.mstorage_block), "iji", "iei", "iii",
				'i', new ItemStack(Items.iron_ingot),
				'j', new ItemStack(Blocks.jukebox),
				'e', new ItemStack(Items.ender_pearl));
		GameRegistry.addRecipe(new ItemStack(ModItems.record_blank), " p ", "prp", " p ",
				'r', new ItemStack(Items.redstone),
				'p', new ItemStack(Items.paper));
	}
	
	@EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {
		
	}
	
	
	
	
	public static CreativeTabs tabMoreMusicMod = new CreativeTabs("tabMoreMusicMod") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(Blocks.jukebox);
	    }
	};
}
