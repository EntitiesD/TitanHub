package TitanCore.Pet;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class IronGolemPet extends Pet implements VanityItem{

	public IronGolemPet(String petname, Player owner) {
		super(petname, owner, EntityType.IRON_GOLEM);
	}
	
	@Override
	public String getItemName() {
		return "Iron Golem Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.IRONINGOT, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public String[] getDescription() {
		return new String[]{CC.tnInfo + "Click to access the", CC.tnValue + "Iron Golem Pet"};
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.IRONINGOT);
	}

	@Override
	public String getPermRequired() {
		return "irongolempet";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.TITAN;
	}

}
