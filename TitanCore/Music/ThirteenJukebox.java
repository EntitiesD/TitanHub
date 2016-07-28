package TitanCore.Music;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class ThirteenJukebox extends Music implements VanityItem{

	public ThirteenJukebox(Player owner) {
		super(3560L, owner, Material.GOLD_RECORD);
	}

	@Override
	public String getItemName() {
		return "Thirteen Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.THIRTEENDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.THIRTEENDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the 13 record!"};
	}

	@Override
	public String getPermRequired() {
		return "thirteenjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}
	

}
