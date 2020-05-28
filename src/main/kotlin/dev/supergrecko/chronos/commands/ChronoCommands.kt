package dev.supergrecko.chronos.commands

import dev.supergrecko.chronos.dataclasses.BotConfiguration
import dev.supergrecko.chronos.extensions.PermissionLevel
import dev.supergrecko.chronos.extensions.permission
import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands

@CommandSet("AutomaticSlowmode")
internal fun chronoCommands(config: BotConfiguration) = commands {
    command("Disable") {
        permission = PermissionLevel.ADMIN
        execute {
            config.enableChronoTimer = false

            it.respond("Chrono message tracking has been disabled")
        }
    }

    command("Enable") {
        permission = PermissionLevel.ADMIN
        execute {
            val threads = Runtime.getRuntime().availableProcessors()

            if (threads > 1) {
                config.enableChronoTimer = true

                it.respond("Chrono message tracking has been enabled")
            } else {
                it.respond(
                    "Cannot enable message tracking, only $threads " +
                            "available. 2 required."
                )
            }
        }
    }
}