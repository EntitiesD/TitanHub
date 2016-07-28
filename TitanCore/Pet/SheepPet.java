package TitanCore.Pet;

import TitanCore.Vanity.VanityItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class SheepPet extends Pet implements VanityItem {

	public SheepPet(String petname, Player owner) {
		super(petname, owner, EntityType.SHEEP);
	}

	@Override
	public String getItemName() {
		return "Sheep Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNSHEEP, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNSHEEP);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Click to access the", CC.tnValue + "Sheep Pet"};
	}

	@Override
	public String getPermRequired() {
		return "sheeppet";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}

}
