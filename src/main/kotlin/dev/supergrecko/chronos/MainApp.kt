package dev.supergrecko.chronos

import me.aberrantfox.kjdautils.api.dsl.PrefixDeleteMode
import me.aberrantfox.kjdautils.api.startBot

fun main(args: Array<String>) {
    val token = args.firstOrNull()
        ?: throw IllegalArgumentException("Missing bot token")

    startBot(token) {
        configure {
            globalPath = "dev.supergrecko.chronos."
            prefix = "chrono!"
            deleteMode = PrefixDeleteMode.Single
            reactToCommands = true
        }
    }
}
