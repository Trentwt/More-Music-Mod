package trentwt.moremusicmod.proxy;

import trentwt.moremusicmod.Items;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		try {
			Items.registerItemRenders();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
