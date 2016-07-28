package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class ElevenJukebox extends Music implements VanityItem {

	public ElevenJukebox(Player owner) {
		super(1421L, owner, Material.RECORD_11);
	}

	@Override
	public String getItemName() {
		return "Eleven Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.ELEVENDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.ELEVENDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the 11 record!"};
	}

	@Override
	public String getPermRequired() {
		return "elevenjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.TITAN;
	}

}
