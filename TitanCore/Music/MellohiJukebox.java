package TitanCore.Music;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class MellohiJukebox extends Music implements VanityItem {

	public MellohiJukebox(Player owner) {
		super(1920L, owner, Material.RECORD_7);
	}
	
	@Override
	public String getItemName() {
		return "Mellohi Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.MELLOHIDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.MELLOHIDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the mellohi record!"};
	}

	@Override
	public String getPermRequired() {
		return "mellohijukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}

}
