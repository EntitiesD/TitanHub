package TitanCore.Music;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class WaitJukebox extends Music implements VanityItem{

	public WaitJukebox(Player owner) {
		super(4760L, owner, Material.RECORD_12);
	}
	
	@Override
	public String getItemName() {
		return "Wait Jukebox";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.WAITDISC, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.WAITDISC);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Spawns a jukebox block", CC.tnInfo + "near you and plays", CC.tnInfo + "the wait record!"};
	}

	@Override
	public String getPermRequired() {
		return "waitjukebox";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.TITAN;
	}

}
