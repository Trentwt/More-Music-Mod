package trentwt.moremusicmod;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
		Items.init();
		Items.register();
	}
	
	@EventHandler
	public void initialization(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {
		
	}
	
	
	
	
	public static CreativeTabs tabMoreMusicMod = new CreativeTabs("moreMusicMod") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(Blocks.jukebox);
	    }
	};
}
