package me.httppython.simpletab.listener

import me.httppython.simpletab.SimpleTab
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class QuitListener: Listener {

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        var config : FileConfiguration = SimpleTab.plugin!!.config
        for(p in Bukkit.getOnlinePlayers()) {
            p.setPlayerListHeaderFooter(ChatColor.translateAlternateColorCodes('&', config.getString("Header")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString()))
                , ChatColor.translateAlternateColorCodes('&', config.getString("Footer")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString())))
        }
    }

}