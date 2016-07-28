package TitanCore.Pet;

import TitanCore.Vanity.VanityItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class WolfPet extends Pet implements VanityItem {

	public WolfPet(String petname, Player owner) {
		super(petname, owner, EntityType.WOLF);
	}

	@Override
	public String getItemName() {
		return "Wolf Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNWOLF, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNWOLF);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Click to access the", CC.tnValue + "Wolf Pet"};
	}

	@Override
	public String getPermRequired() {
		return "wolfpet";
	}

	@Override
	public Rank getExclusiveRank() {
		return null;
	}

}
