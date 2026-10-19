package net.kingidk.geyserCombatLogWorkaround;

import io.papermc.paper.event.player.PlayerClientLoadedWorldEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GeyserCombatLogWorkaround extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onClientLoadedWorld(PlayerClientLoadedWorldEvent event) {
        Player player = event.getPlayer();
        player.getScheduler().run(this, task -> {
            if (player.isDead()) player.spigot().respawn();
        }, null);
    }

}
