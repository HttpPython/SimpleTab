package me.httppython.simpletab

import me.httppython.simpletab.listener.JoinListener
import me.httppython.simpletab.listener.QuitListener
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class SimpleTab: JavaPlugin() {

    companion object {
        var consolePrefix : String = "§b§lSimpleTab §8» "
        var chatPrefix : String = ChatColor.translateAlternateColorCodes('&', "&x&1&5&c&4&f&b&lS&x&1&e&b&f&f&b&li&x&2&7&b&a&f&c&lm&x&3&0&b&5&f&c&lp&x&3&9&b&0&f&c&ll&x&4&1&a&b&f&c&le&x&4&a&a&6&f&d&lT&x&5&3&a&1&f&d&la&x&5&c&9&c&f&d&lb &8» ")
        var plugin : SimpleTab? = null
    }

    override fun onEnable() {
        plugin = this;
        if(!File("plugins/SimpleTab/config.yml").exists()) {
            var file : File = File("plugins/SimpleTab/config.yml")
            var config : YamlConfiguration = YamlConfiguration.loadConfiguration(file)
            config.set("Header", "\n&x&1&5&c&4&f&b&lS&x&1&e&b&f&f&b&li&x&2&7&b&a&f&c&lm&x&3&0&b&5&f&c&lp&x&3&9&b&0&f&c&ll&x&4&1&a&b&f&c&le&x&4&a&a&6&f&d&lT&x&5&3&a&1&f&d&la&x&5&c&9&c&f&d&lb &8| §7Your Server §8» §b1.18.1+\n§7§7Players §8» §b%players%§8/§b%max_players%\n ")
            config.set("Footer", "\n§7Made by HttpPython for your server!\n§7Download: §7spigotmc")
            config.save(file)
        }
        var pluginManager : PluginManager = Bukkit.getPluginManager()
        pluginManager.registerEvents(JoinListener(), this)
        pluginManager.registerEvents(QuitListener(), this)
        Bukkit.getConsoleSender().sendMessage("${consolePrefix}§aThe Plugin is now ready to use!")
        for(p in Bukkit.getOnlinePlayers()) {
            p.setPlayerListHeaderFooter(ChatColor.translateAlternateColorCodes('&', config.getString("Header")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString()))
                , ChatColor.translateAlternateColorCodes('&', config.getString("Footer")!!.replace("%players%", Bukkit.getOnlinePlayers().size.toString()).replace("%max_players%", Bukkit.getMaxPlayers().toString())))
        }
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("${consolePrefix}§cBye!")
    }

}