package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class WardJukebox extends Music implements VanityItem {

	public WardJukebox(Player owner) {
		super(5020L, owner, Material.RECORD_10);
	}

	@Override
	public String getItemName() {
		return "Ward Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.WARDDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.WARDDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the ward record!"};
	}

	@Override
	public String getPermRequired() {
		return "wardjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.TITAN;
	}

}
