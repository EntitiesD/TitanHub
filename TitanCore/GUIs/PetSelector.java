package TitanCore.GUIs;

import java.util.List;

import TitanCore.Util.PermsHandler;
import org.bukkit.entity.Player;

import TitanCore.Pet.PetManager;
import TitanCore.Vanity.VanityItem;
import TitanCore.Vanity.VanityManager;

public class PetSelector extends GUI{
	
	public PetSelector(Player p) {
		super("Pets", 35, p);
	}

	@Override
	public void open()
	{
		Player p = getViewer();
		List<VanityItem> icons = VanityManager.getAvailablePets();
		
		int index = 11;
		
		for (VanityItem icon : icons)
		{
			if ((PetManager.getActiveItem(p) != null) && (icon.getActiveIcon().getItemMeta().getDisplayName().equalsIgnoreCase(PetManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName())))
			{
				setActiveIcon(index, icon);
			}
			else if (PermsHandler.checkAccess(p, icon.getPermRequired()))
			{
				setIconUnlocked(index, icon);
			}
			else
			{
				if (icon.getExclusiveRank() != null)
				{
					setIconUnlockRank(index, icon);
				}
				else
				{
					setIconUnlockStore(index, icon);
				}
			}
			index++;
			if (index == 16)
			{
				index = 20;
			}
		}
		
		setIcon(4, VanityManager.vanityBack());
		p.openInventory(getMenu());
		p.updateInventory();
	}
}
