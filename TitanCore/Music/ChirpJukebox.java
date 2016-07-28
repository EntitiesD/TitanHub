package TitanCore.Music;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class ChirpJukebox extends Music implements VanityItem{

	public ChirpJukebox(Player owner) {
		super(3700L, owner, Material.RECORD_4);
	}

	@Override
	public String getItemName() {
		return "Chirp Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.CHIRPDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.CHIRPDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the chirp record!"};
	}

	@Override
	public String getPermRequired() {
		return "chirpjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}

}
