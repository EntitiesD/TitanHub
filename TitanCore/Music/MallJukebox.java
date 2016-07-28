package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class MallJukebox extends Music implements VanityItem {

	public MallJukebox(Player owner) {
		super(3940L, owner, Material.RECORD_6);
	}
	
	@Override
	public String getItemName() {
		return "Mall Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.MALLDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.MALLDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the mall record!"};
	}

	@Override
	public String getPermRequired() {
		return "malljukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}

}
