package TitanCore.Pet;

import TitanCore.Vanity.VanityItem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

public class ChickenPet extends Pet implements VanityItem {

	public ChickenPet(String petname, Player owner) {
		super(petname, owner, EntityType.CHICKEN);
	}

	@Override
	public String getItemName() {
		return "Chicken Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNCHICKEN, CC.tnEnable + CC.BOLD + "Activate " + CC.tnGUIHead + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNCHICKEN);
	}

	@Override
	public String[] getDescription() {
		return new String[]{CC.tnInfo + "Click to access the", CC.tnValue + "Chicken Pet"};
	}

	@Override
	public String getPermRequired() {
		return "chickenpet";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}

}
