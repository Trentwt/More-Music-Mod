package trentwt.moremusicmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import trentwt.moremusicmod.MoreMusicMod;

public class DiskWriterBlock extends Block {
	
	private static Boolean isWriting;
	
	public DiskWriterBlock(boolean b) {
		super(Material.iron);
		this.setCreativeTab(MoreMusicMod.tabMoreMusicMod);
	}
}
