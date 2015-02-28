package trentwt.moremusicmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	public static Block iard_block;
	
	public static void init() {
		iard_block = new IARDBlock().setUnlocalizedName("iard_block");
	}
	
	public static void register() {
		GameRegistry.registerBlock(iard_block, "Inter-Dimensional Audio Retrieval Device");
	}
}
