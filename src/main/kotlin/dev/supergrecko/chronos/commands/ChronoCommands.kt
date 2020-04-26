package dev.supergrecko.chronos.commands

import dev.supergrecko.chronos.dataclasses.BotConfiguration
import dev.supergrecko.chronos.extensions.PermissionLevel
import dev.supergrecko.chronos.extensions.permission
import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands

@CommandSet("Chrono")
internal fun chronoCommands(config: BotConfiguration) = commands {
    command("Chrono") {
        permission = PermissionLevel.ADMIN

        execute {
            val threads = Runtime.getRuntime().availableProcessors()

            val result = if (config.enableChronoTimer) {
                "Chrono is enabled. Server is running with $threads threads."
            } else {
                "Chrono is disabled. $threads available threads."
            }

            it.respond(result)
        }
    }

    command("EnableChrono") {
        permission = PermissionLevel.ADMIN

        execute {

        }
    }

    command("DisableChrono") {
        permission = PermissionLevel.ADMIN

        execute {

        }
    }
}