package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class StalJukebox extends Music implements VanityItem {

	public StalJukebox(Player owner) {
		super(3000L, owner, Material.RECORD_8);
	}
	
	@Override
	public String getItemName() {
		return "Stal Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.STALDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.STALDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the stal record!"};
	}

	@Override
	public String getPermRequired() {
		return "staljukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}
}