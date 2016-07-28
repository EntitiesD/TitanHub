package TitanCore.Pet;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class PigPet extends Pet implements VanityItem{

	public PigPet(String petname, Player owner) {
		super(petname, owner, EntityType.PIG);
	}

	@Override
	public String getItemName() {
		return "Pig Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNPIG, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public String[] getDescription() {
		return new String[]{CC.tnInfo + "Click to access the", CC.tnValue + "Pig Pet"};
	}

	@Override
	public String getPermRequired() {
		return "pigpet";
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNPIG);
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}


}
