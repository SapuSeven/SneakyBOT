package com.sapuseven.sneakybot.commands

import com.sapuseven.sneakybot.SneakyBot
import com.sapuseven.sneakybot.utils.Command
import com.sapuseven.sneakybot.utils.ConsoleCommand
import org.slf4j.LoggerFactory

internal class CommandReload(private val bot: SneakyBot) : BuiltinCommand() {
    override val command: Command = Command()
    private val log = LoggerFactory.getLogger(CommandReload::class.java)

    init {
        command.commandName = "reload"
        command.help = "Reload all plugins."
    }

    override fun execute(cmd: ConsoleCommand, invokerId: Int): Boolean {
        log.info("Reloading plugins and config...")

        bot.stopPlugins()
        bot.loadPlugins()

        bot.preInit()

        bot.postInit()

        log.info("All plugins reloaded.")
        val msg = "Plugins reloaded (${bot.commands.size} commands and ${bot.services.size} services active)."
        if (bot.mode == SneakyBot.MODE_CHANNEL)
            bot.sendChannelMessage(msg)
        else if (bot.mode == SneakyBot.MODE_DIRECT)
            bot.sendDirectMessage(msg)
        return true
    }
}
