package TitanCore.Pet;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class CowPet extends Pet implements VanityItem {

	public CowPet(String petname, Player owner) {
		super(petname, owner, EntityType.COW);
	}

	@Override
	public String getItemName() {
		return "Cow Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNCOW, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNCOW);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Click to access the", CC.tnValue + "Cow Pet"};
	}

	@Override
	public String getPermRequired() {
		return "cowpet";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}

}
