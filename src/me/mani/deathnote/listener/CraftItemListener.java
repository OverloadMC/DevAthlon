package me.mani.deathnote.listener;

import java.util.Arrays;

import me.mani.deathnote.DeathNote;
import me.mani.deathnote.DeathNoteListener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftItemListener extends DeathNoteListener {

	@EventHandler
	public void onCraftItem(CraftItemEvent ev) {
		
		if (ev.getRecipe().getResult().getType() == Material.NAME_TAG) {
			String ownerName = "�c???";
			for (ItemStack itemStack : ev.getInventory().getMatrix())
				if (itemStack != null && itemStack.getType() == Material.POTION)
					ownerName = itemStack.getItemMeta().getLore().get(0);
			ItemStack itemStack = DeathNote.getInstance().getGameManager().itemManager.getItemStack(Material.NAME_TAG);
			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.setDisplayName(ownerName + "�7's Death Note");
			itemMeta.setLore(Arrays.asList(ownerName));
			itemStack.setItemMeta(itemMeta);
			ev.setCurrentItem(itemStack);
			ev.getWhoClicked().getInventory().setItem(1, DeathNote.getInstance().getGameManager().itemManager.getItemStack(Material.GLASS_BOTTLE));
		}
		
	}
	
}
