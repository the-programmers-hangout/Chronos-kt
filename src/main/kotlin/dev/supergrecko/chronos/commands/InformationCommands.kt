package dev.supergrecko.chronos.commands

import dev.supergrecko.chronos.extensions.PermissionLevel
import dev.supergrecko.chronos.extensions.permission
import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.api.dsl.embed
import me.aberrantfox.kjdautils.internal.arguments.TextChannelArg

@CommandSet("Information")
internal fun informationCommands() = commands {
    command("GetInterval") {
        permission = PermissionLevel.ADMIN
        execute(TextChannelArg) {
            val (channel) = it.args

            val result = embed {
                title = "Channel Slow-mode Interval"

                description = """
                    Showing results for ${channel.asMention}
                    
                    Interval: ${channel.slowmode} seconds
                """.trimIndent()
            }

            it.respond(result)
        }
    }

    command("GetIntervals") {
        permission = PermissionLevel.ADMIN
        execute {
            val channels = it.guild?.textChannels ?: listOf()

            val result = embed {
                title = "Channel Slow-mode Intervals"

                description = """
                    Showing results for all channels where slow-mode is enabled
                    
                    ${channels.filter { it.slowmode != 0 }
                    .joinToString("\n") { channel ->
                        "${channel.asMention}: ${channel.slowmode} seconds"
                    }}
                """.trimIndent()
            }

            it.respond(result)
        }
    }
}