package TitanCore.Particle;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import titancoreapi.API.Util.CC;
import titancoreapi.API.Util.ItemStackFactory;
import titancoreapi.Core.Items;
import titancoreapi.Core.Rank;
import TitanCore.Vanity.VanityItem;

public class ThunderCloudParticle extends Particle implements VanityItem{

	public ThunderCloudParticle(Player p) {
		super(20L, 1L, p);
	}
	
	private double radialsPerStep = Math.PI / 8;
	
	private float step = 0;
	
	private float radius = 1.0F;

	@Override
	public void tick() {
		
		Location loc = getOwner().getEyeLocation();
		loc.add(0, 0.5, 0);
		loc.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);
		loc.getWorld().spigot().playEffect(loc, Effect.VILLAGER_THUNDERCLOUD, 0, 0, 0F, 0F, 0F, 0F, 1, 50);
		step++;
		
	}

	@Override
	public String getItemName() {
		return "Thunder Cloud Particle";
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStackFactory().createItemStackwithLore(Items.FIRECHARGE, CC.tnGUIHead + "Activate " + getItemName(), getDescription());
	}

	@Override
	public ItemStack getActiveIcon() {
		return new ItemStackFactory().createItemStackwithGlow(CC.tnDisable + CC.BOLD + "Deactivate " + CC.tnGUIHead + getItemName(), Items.FIRECHARGE);
	}

	@Override
	public String[] getDescription() {
		return new String[] {CC.tnInfo + "Gives you a rotating", CC.tnInfo + "thunder cloud effect above", CC.tnInfo + "your head!"};
	}

	@Override
	public String getPermRequired() {
		return "thundercloudparticle";
	}

	@Override
	public Rank getExclusiveRank() {
		return Rank.MVP;
	}
}
