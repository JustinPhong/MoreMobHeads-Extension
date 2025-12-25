package com.MoreMobHeadsExtension;

import org.bukkit.*;
import org.bukkit.entity.Creeper;
import org.bukkit.event.Listener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class MoreMobHeadsExtension extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        String version = getDescription().getVersion();
        getLogger().info("MoreMobHeadsExtension v" + version + " enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("More Mob Heads Extension disabled.");
    }

    @EventHandler
    public void onServerLoad(ServerLoadEvent event) {
        getServer().getScheduler().runTaskLater(this, () -> {
            getLogger().info("Check out https://github.com/JustinPhong/MoreMobHeads-Extension for more details!");
        }, 20L);
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Location loc = entity.getLocation();
        World world = loc.getWorld();

        if (entity.getLastDamageCause() instanceof EntityDamageByEntityEvent ede) {
            if (ede.getDamager() instanceof Creeper creeper && creeper.isPowered()) {
                if (entity instanceof Player deadPlayer) {
                    if (new Random().nextDouble() < 0.25) {
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
                        if (meta != null) {
                            meta.setOwningPlayer(deadPlayer);
                            meta.setDisplayName(ChatColor.RED + deadPlayer.getName() + "'s Head");
                            playerHead.setItemMeta(meta);
                        }
                        world.dropItemNaturally(loc, playerHead);
                    }
                } else {
                    String mobName = entity.getType().toString().toLowerCase();
                    NamespacedKey key = new NamespacedKey("more_mob_heads", "entities/" + mobName);
                    LootTable lootTable = Bukkit.getServer().getLootTable(key);

                    if (lootTable == null) {
                        getLogger().warning(
                                "Loot table for " + mobName + " could NOT be found on more_mob_heads datapack!");
                        return;
                    }

                    LootContext context = new LootContext.Builder(loc)
                            .lootedEntity(entity)
                            .killer(entity.getKiller())
                            .build();

                    Collection<ItemStack> drops = lootTable.populateLoot(new Random(), context);
                    for (ItemStack item : drops) {
                        world.dropItemNaturally(loc, item);
                    }
                }
            }
        }
    }
}
