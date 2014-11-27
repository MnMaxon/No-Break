package me.MnMaxon.NoBreak;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MainListener implements Listener {
	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void noWeaponBreakDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			ItemStack[] armour = ((Player) e.getEntity()).getInventory().getArmorContents();
			for (ItemStack i : armour)
				i.setDurability((short) -1);
			((Player) e.getEntity()).getInventory().setArmorContents(armour);
		}
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void noWeaponBreakDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && isTool(((Player) e.getDamager()).getItemInHand().getType()))
			((Player) e.getDamager()).getItemInHand().setDurability((short) -1);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void noWeaponBreakDamage(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player)
			e.getBow().setDurability((short) -1);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void noWeaponBreakDamage(PlayerInteractEvent e) {
		if (e.getItem() != null) {
			if (this.isTool(e.getItem().getType()) || e.getItem().getType() == Material.FISHING_ROD
					|| e.getItem().getType() == Material.FLINT_AND_STEEL)
				e.getItem().setDurability((short) -1);
		}
	}

	private boolean isTool(Material material) {
		return material == Material.WOOD_SWORD || material == Material.STONE_SWORD || material == Material.GOLD_SWORD
				|| material == Material.IRON_SWORD || material == Material.DIAMOND_SWORD
				|| material == Material.WOOD_PICKAXE || material == Material.STONE_PICKAXE
				|| material == Material.GOLD_PICKAXE || material == Material.IRON_PICKAXE
				|| material == Material.DIAMOND_PICKAXE || material == Material.WOOD_AXE
				|| material == Material.STONE_AXE || material == Material.GOLD_AXE || material == Material.IRON_AXE
				|| material == Material.DIAMOND_AXE || material == Material.WOOD_SPADE
				|| material == Material.STONE_SPADE || material == Material.GOLD_SPADE
				|| material == Material.IRON_SPADE || material == Material.DIAMOND_SPADE
				|| material == Material.WOOD_HOE || material == Material.STONE_HOE || material == Material.GOLD_HOE
				|| material == Material.IRON_HOE || material == Material.DIAMOND_HOE;
	}
}
