package TitanCore.Vanity;

import org.bukkit.inventory.ItemStack;

import titancoreapi.Core.Rank;

public interface VanityItem {
	
	public String getItemName();
	public ItemStack getIcon();
	public ItemStack getActiveIcon();
	public String[] getDescription();
	public String getPermRequired();
	public Rank getExclusiveRank();
	
}
