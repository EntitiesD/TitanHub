package TitanCore.Vanity;

import TitanCore.Disguise.*;
import TitanCore.GUIs.*;
import TitanCore.Gadget.*;
import TitanCore.Hub.HubManager;
import TitanCore.Music.*;
import TitanCore.Particle.*;
import TitanCore.Pet.*;
import TitanCore.TCHub;
import TitanCore.Util.PermsHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import titancoreapi.API.Stats.StatManager;
import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.API.Util.UtilPlayer;
import titancoreapi.API.Util.UtilPlayer.playerSounds;
import titancoreapi.Core.Category;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import titancoreapi.Core.Travel.SendtoServer;

import java.util.ArrayList;
import java.util.List;

public class VanityManager {

	private static TCHub main = TCHub.getInstance();
	private static List<VanityItem> pets = new ArrayList<VanityItem>();
	private static List<VanityItem> particles = new ArrayList<VanityItem>();
	private static List<VanityItem> music = new ArrayList<VanityItem>();
	private static List<VanityItem> gadgets = new ArrayList<VanityItem>();
	private static List<VanityItem> disguises = new ArrayList<VanityItem>();
	
	public static boolean loadItems()
	{
		//Pets
		pets.add(new ChickenPet(null, null));
		pets.add(new CowPet(null, null));
		pets.add(new IronGolemPet(null, null));
		pets.add(new MooshroomPet(null, null));
		pets.add(new OcelotPet(null, null));
		pets.add(new PigPet(null, null));
		pets.add(new RabbitPet(null, null));
		pets.add(new SheepPet(null, null));
		pets.add(new WolfPet(null, null));
		
		//Particles
		particles.add(new FireWalkParticle(null));
		particles.add(new FlameHelixParticle(null));
		particles.add(new HeartParticle(null));
		particles.add(new LavaDropletParticle(null));
		particles.add(new NotesParticle(null));
		particles.add(new RainCloudParticle(null));
		particles.add(new ThunderCloudParticle(null));
		particles.add(new WaterDropletParticle(null));
		particles.add(new WhiteHaloParticle(null));
		
		//Music
		music.add(new BlocksJukebox(null));
		music.add(new CatJukebox(null));
		music.add(new ChirpJukebox(null));
		music.add(new ElevenJukebox(null));
		music.add(new FarJukebox(null));
		music.add(new MallJukebox(null));
		music.add(new MellohiJukebox(null));
		music.add(new StalJukebox(null));
		music.add(new StradJukebox(null));
		music.add(new ThirteenJukebox(null));
		music.add(new WaitJukebox(null));
		music.add(new WardJukebox(null));
		
		//Gadgets
		gadgets.add(new FireworkLauncherGadget(null));
		gadgets.add(new FunGunGadget(null));
		gadgets.add(new MelonLauncherGadget(null));
		gadgets.add(new SmiteGadget(null));
		gadgets.add(new SpeedGunGadget(null));
		gadgets.add(new TNTGadget(null));
		gadgets.add(new WitherLauncherGadget(null));
		gadgets.add(new PearlFlightGadget(null));
		
		//Disguises
		disguises.add(new BlazeDisguise(null));
		disguises.add(new ChickenDisguise(null));
		disguises.add(new CowDisguise(null));
		disguises.add(new CreeperDisguise(null));
		disguises.add(new EndermanDisguise(null));
		disguises.add(new PigDisguise(null));
		
		return false;
	}
	
	public static boolean hasActiveVanityItem(Player p)
	{
		return false;
	}
	
	
	public static List<VanityItem> getAvailablePets()
	{
		return pets;
	}
	
	public static List<VanityItem> getAvailableParticles()
	{
		return particles;
	}
	
	public static List<VanityItem> getAvailableMusic()
	{
		return music;
	}
	
	public static List<VanityItem> getAvailableGadgets()
	{
		return gadgets;
	}
	
	public static List<VanityItem> getAvailableDisguises()
	{
		return disguises;
	}
	
	public static ItemStack vanityBack()
	{
		return new ItemStackFactory().createItemStack(Items.ARROW, CC.tnGUIHead + "← Back");
	}
	
	public static void equipMessage(Player p, String itemname)
	{
		UtilPlayer.message(Category.VANITY, p, CC.tnInfo + "You " + CC.tnEnable + "equipped " + CC.tnValue + itemname + CC.end);
		UtilPlayer.sound(p, playerSounds.EQUIP);
	}
	
	public static void unequipMessage(Player p, String itemname)
	{
		UtilPlayer.message(Category.VANITY, p, CC.tnInfo + "You " + CC.tnDisable + "unequipped " + CC.tnValue + itemname + CC.end);
		UtilPlayer.sound(p, playerSounds.UNEQUIP);
	}
	
	public static void notUnlockedMessage(Player p)
	{
		UtilPlayer.message(Category.VANITY, p, CC.tnError + "You do not have access to this!");
		UtilPlayer.sound(p, playerSounds.TRANSACTIONFAILED);
	}
	
	public static void useAbility(Player p, String ability)
	{
		UtilPlayer.message(Category.ABILITY, p, CC.tnInfo + "You used " + CC.tnValue + ability + CC.end);
	}
	
	public static void handleEnvChange(Player p)
	{
		if (MusicManager.hasActiveMusic(p))
		{
			MusicManager.removeMusic(p, true);
		}
		if (PetManager.hasActivePet(p))
		{
			PetManager.removePetOwner(p, true);
		}
		if (GadgetManager.hasActiveGadget(p))
		{
			GadgetManager.removeGadget(p, true);
		}
		if (ParticleManager.hasParticle(p))
		{
			ParticleManager.removeParticle(p, true);
		}
		if (WardrobeManager.hasArmor(p))
		{
			WardrobeManager.clearArmor(p);
		}
		if (DisguiseManager.hasActiveDisguise(p))
		{
			DisguiseManager.removeDisguise(p, true);
		}
	}
	
	public static void equipHotbar(Player p)
	{
		ItemStackFactory isf = new ItemStackFactory();
		ItemStack gameselect = isf.createItemStack(Items.COMPASS, CC.tnValue + "Gamemode Selector " + CC.tnUse + "(Right Click)");
		ItemStack nogadget = isf.createItemStack(Items.GLASSPANE, CC.tnValue + "No gadget");
		ItemStack vanity = isf.createItemStack(Items.CHEST, CC.tnValue + "Vanity Menu " + CC.tnUse + "(Right Click)");
		//ItemStack staffmenu = isf.createItemStack(Items.REDSTONE, CC.tnValue + "Staff Menu " + CC.tnUse + "(Right Click)");
		//ItemStack prefs = isf.createItemStack(Items.PAPER, CC.tnValue + "/options " + CC.tnUse + "(Right Click)");
		ItemStack profile = isf.createItemStackPlayerHead(CC.tnValue + "/profile " + CC.tnUse + "(Right Click)", p.getName());
		
		Inventory pi = p.getInventory();
		
		//if (UtilPlayer.isStaff(p))
		//{
			//pi.setItem(1, staffmenu);
		//}
		
		pi.setItem(0, gameselect);
		pi.setItem(2, nogadget);
		pi.setItem(4, vanity);
		//pi.setItem(8, prefs);
		pi.setItem(8, profile);
	}
	
	public static void handleInteract(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if (!p.getItemInHand().hasItemMeta())
		{
			return;
		}
		if ((e.getAction() != Action.RIGHT_CLICK_AIR) && (e.getAction() != Action.RIGHT_CLICK_BLOCK))
		{
			return;
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().startsWith(CC.tnValue + "Gamemode Selector"))
		{
			GamemodeSelector gm = new GamemodeSelector(p);
			gm.load();
			gm.open();
			return;
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().startsWith(CC.tnValue + "Vanity Menu"))
		{
			VanityMenu vanitymenu = new VanityMenu(p);
			vanitymenu.load();
			vanitymenu.open();
			return;
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().startsWith(CC.tnValue + "Staff Menu"))
		{
			return;
		}
		if (p.getItemInHand().getItemMeta().getDisplayName().startsWith(CC.tnValue + "/profile"))
		{
			if (!StatManager.isInCache(p))
			{
				return;
			}
			Profile profile = new Profile(p);
			profile.load();
			profile.open();
			return;
		}
	}
	
	public static void handleInvClick(InventoryClickEvent e)
	{
		if (e.getInventory().getTitle().equalsIgnoreCase("Vanity Menu"))
		{
			e.setCancelled(true);
			if (!(e.getWhoClicked() instanceof Player))
			{
				return;
			}
			final Player p = (Player)e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			if ((item == null) || (!item.hasItemMeta()))
			{
				return;
			}
			ItemMeta clicked = item.getItemMeta();
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Pets"))
			{
				openGUI(p, new PetSelector(p));
				return;
			}
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Gadgets"))
			{
				openGUI(p, new GadgetSelector(p));
				return;
			}
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Particle Effects"))
			{
				openGUI(p, new ParticleSelector(p));
				return;
			}
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Disguises"))
			{
				UtilPlayer.message(Category.VANITY, p, CC.tnInfo + "Disguises are disabled temporarily while we fix a major issue! Aplogogies for any inconvenience!");
				return;
			}
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Music"))
			{
				openGUI(p, new MusicSelector(p));
				
				return;
			}
			if (clicked.getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Wardrobe"))
			{
				if (PermsHandler.checkAccess(p, "wardrobe"))
				{
					openGUI(p, new Wardrobe(p));
					return;
				}
				else
				{
					p.closeInventory();
					UtilPlayer.sound(p, playerSounds.TRANSACTIONFAILED);
					UtilPlayer.message(Category.VANITY, p, CC.tnError + "You do not have access to the wardrobe!" + CC.tnInfo + "Purchase " + Rank.getRankPrefix(Rank.MVP) + CC.tnInfo + " rank at " + CC.tnValue + "store.TitanCore.com");
					return;
				}
			}
			if (PetManager.getActiveItem(p) != null)
			{
				 if (clicked.getDisplayName().equalsIgnoreCase(PetManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName()))
				 {
					 PetManager.removePetOwner(p, false);
				 }
			}
			if (ParticleManager.getActiveItem(p) != null)
			{
				if (clicked.getDisplayName().equalsIgnoreCase(ParticleManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName()))
				{
					ParticleManager.removeParticle(p, false);
				}
			}
			if (MusicManager.getActiveItem(p) != null)
			{
				if (clicked.getDisplayName().equalsIgnoreCase(MusicManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName()))
				{
					MusicManager.removeMusic(p, false);
				}
			}
			if (GadgetManager.getActiveItem(p) != null)
			{
				if (clicked.getDisplayName().equalsIgnoreCase(GadgetManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName()))
				{
					GadgetManager.removeGadget(p, false);
				}
			}
			if (DisguiseManager.getActiveItem(p) != null)
			{
				if (clicked.getDisplayName().equalsIgnoreCase(DisguiseManager.getActiveItem(p).getActiveIcon().getItemMeta().getDisplayName()))
				{
					DisguiseManager.removeDisguise(p, false);
				}
			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					p.closeInventory();
					p.updateInventory();
					VanityMenu mainmenu = new VanityMenu(p);
					mainmenu.load();
					mainmenu.open();
				}
			}.runTask(main);
		}
		if (e.getInventory().getTitle().equalsIgnoreCase("Profile"))
		{
			Player p = (Player)e.getWhoClicked();
			UtilPlayer.sound(p, playerSounds.GUI_NULL);
			e.setCancelled(true);
		}
		if (e.getInventory().getTitle().equalsIgnoreCase("Gamemode Selector"))
		{
			e.setCancelled(true);
			if (!(e.getWhoClicked() instanceof Player))
			{
				return;
			}
			final Player p = (Player)e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			if ((item == null) || (!item.hasItemMeta()))
			{
				return;
			}
			if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "KitPVP"))
			{
				new SendtoServer(p, "kitpve");
				UtilPlayer.message(Category.TRAVEL, p, CC.tnInfo + "Sending you to " + CC.tnValue + "KitPVP" + CC.tnInfo + "...");
				p.closeInventory();
			}
			if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Hub"))
			{
				p.chat("/hub");
				p.closeInventory();
			}
			if (item.getItemMeta().getDisplayName().equalsIgnoreCase(CC.tnGUIHead + "Borderline"))
			{
				if (p.getWorld().getName().equalsIgnoreCase("hub-borderline"))
				{
					UtilPlayer.message(Category.HUB, p, CC.tnError + "You are already in the borderline hub!");
					return;
				}
				UtilPlayer.message(Category.TRAVEL, p, CC.tnInfo + "Sending you to " + CC.tnValue + "Borderline" + CC.tnInfo + "...");
				HubManager.sendToBorderlineHub(p);
				p.closeInventory();
			}
		}
		
	}
	
	public static void openGUI(final Player p, final GUI gui)
	{
		p.closeInventory();
		UtilPlayer.sound(p, playerSounds.GUI_PAGECHANGE);
		gui.load();
		gui.open();
	}
	
}
