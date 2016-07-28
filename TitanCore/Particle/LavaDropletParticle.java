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

public class LavaDropletParticle extends Particle implements VanityItem {

	public LavaDropletParticle(Player p) {
		super(20L, 2L, p);
	}
	
	private double radialsPerStep = Math.PI / 8;
	
	private float step = 0;
	
	private float radius = 1.0F;

	@Override
	public void tick() {
		
		Location loc = getOwner().getEyeLocation();
		loc.add(0, 0.5, 0);
		loc.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);
		loc.getWorld().spigot().playEffect(loc, Effect.LAVADRIP, 0, 0, 0F, 0F, 0F, 0F, 1, 50);
		step++;
	}

	@Override
	public String getItemName() {
		return "Lava Droplet Particle";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.LAVABUCKET, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.LAVABUCKET);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Gives you a rotating", CC.tnInfo + "effect of lava droplets!"};
	}

	@Override
	public String getPermRequired() {
		return "lavadropletparticle";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}

}
