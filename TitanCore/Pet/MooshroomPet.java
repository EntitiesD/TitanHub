package TitanCore.Pet;

import TitanCore.Vanity.VanityItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class MooshroomPet extends Pet implements VanityItem {

	public MooshroomPet(String petname, Player owner) {
		super(petname, owner, EntityType.MUSHROOM_COW);
	}

	@Override
	public String getItemName() {
		return "Mooshroom Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNMOOSHROOM, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNMOOSHROOM);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Click to access the", CC.tnValue + "Mooshroom Pet"};
	}

	@Override
	public String getPermRequired() {
		return "mooshroompet";
	}

	@Override
	public Rank getExclusiveRank() {
		return null;
	}

}
