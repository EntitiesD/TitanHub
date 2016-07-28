package TitanCore.Particle;

import TitanCore.Vanity.VanityItem;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;

import java.util.Random;

public class FireWalkParticle extends Particle implements VanityItem {

	public FireWalkParticle(Player p) {
		super(0L, 2L, p);
	}

	@Override
	public void tick() {
		Location loc = getOwner().getLocation();
		loc.add(0, 0.2, 0);
		loc.getWorld().spigot().playEffect(loc, Effect.LARGE_SMOKE, 0, 0, 0.3F, 0F, 0.3F, 0F, 4, 50);
		Random rand = new Random();
		int flame = rand.nextInt(6);
		if (flame == 2)
		{
			loc.getWorld().spigot().playEffect(loc, Effect.FLAME, 0, 0, 0.3F, 0.1F, 0.3F, 0F, 2, 50);
		}
	}

	@Override
	public String getItemName() {
		return "Fire Walk Particle";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.FLINTANDSTEEL, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.FLINTANDSTEEL);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Gives you a smoke", CC.tnInfo + "trail at your feet with", CC.tnInfo + "some small flames!"};
	}

	@Override
	public String getPermRequired() {
		return "firewalkparticle";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.VIP;
	}

}
