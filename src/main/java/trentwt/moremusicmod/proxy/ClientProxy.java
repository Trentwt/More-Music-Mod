package trentwt.moremusicmod.proxy;

import java.util.logging.Logger;

import trentwt.moremusicmod.ModBlocks;
import trentwt.moremusicmod.ModItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		try {
			ModItems.registerItemRenders();
			ModBlocks.registerBlockRenders();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
