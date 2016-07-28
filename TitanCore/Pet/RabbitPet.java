package TitanCore.Pet;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class RabbitPet extends Pet implements VanityItem {

	public RabbitPet(String petname, Player owner) {
		super(petname, owner, EntityType.RABBIT);
	}

	@Override
	public String getItemName() {
		return "Rabbit Pet";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.SPAWNRABBIT, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.SPAWNRABBIT);
	}

	@Override
	public String[] getDescription() {
		return new String[]{CC.tnInfo + "Click to access the", CC.tnValue + "Rabbit Pet"};
	}

	@Override
	public String getPermRequired() {
		return "rabbitpet";
	}

	@Override
	public Rank getExclusiveRank() {
		return null;
	}

}
