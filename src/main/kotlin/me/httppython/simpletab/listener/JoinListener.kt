package me.httppython.simpletab.listener

import me.httppython.simpletab.SimpleTab
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent


class JoinListener: Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        var player : Player = event.player
        var config : FileConfiguration = SimpleTab.plugin!!.config
        player.setPlayerListHeaderFooter(ChatColor.translateAlternateColorCodes('&', config.getString("Header")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString()))
            , ChatColor.translateAlternateColorCodes('&', config.getString("Footer")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString())))
        for(p in Bukkit.getOnlinePlayers()) {
            p.setPlayerListHeaderFooter(
                ChatColor.translateAlternateColorCodes('&', config.getString("Header")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString()))
                , ChatColor.translateAlternateColorCodes('&', config.getString("Footer")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString())))
        }
    }

}