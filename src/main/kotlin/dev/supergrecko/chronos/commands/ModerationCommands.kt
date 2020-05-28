package dev.supergrecko.chronos.commands

import dev.supergrecko.chronos.extensions.PermissionLevel
import dev.supergrecko.chronos.extensions.permission
import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.internal.arguments.TextChannelArg
import me.aberrantfox.kjdautils.internal.arguments.TimeStringArg

@CommandSet("Moderation")
internal fun moderationCommands() = commands {
    command("SetInterval") {
        permission = PermissionLevel.ADMIN
        execute(TextChannelArg, TimeStringArg) {
            val (channel, interval) = it.args

            if (interval > 21600 || interval < 0) {
                return@execute it.respond("Invalid time element passed.")
            }

            channel.manager.setSlowmode(interval.toInt()).queue { _ ->
                it.respond("Successfully set slow-mode in channel ${channel
                    .asMention} to ${interval.toInt()} seconds.")
            }
        }
    }
}