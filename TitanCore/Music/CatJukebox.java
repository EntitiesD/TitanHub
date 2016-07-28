package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class CatJukebox extends Music implements VanityItem {

	public CatJukebox(Player owner) {
		super(3700L, owner, Material.GREEN_RECORD);
	}

	@Override
	public String getItemName() {
		return "Cat Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.CATDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.CATDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the cat record!"};
	}

	@Override
	public String getPermRequired() {
		return "catjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}

}
