package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class BlocksJukebox extends Music implements VanityItem {

	public BlocksJukebox(Player owner) {
		super(6900L, owner, Material.RECORD_3);
	}

	@Override
	public String getItemName() {
		return "Blocks Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.BLOCKSDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.BLOCKSDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the blocks record!"};
	}

	@Override
	public String getPermRequired() {
		return "blocksjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}
	
	
}
