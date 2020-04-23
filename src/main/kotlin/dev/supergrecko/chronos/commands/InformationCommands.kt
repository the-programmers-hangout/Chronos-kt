package dev.supergrecko.chronos.commands

import me.aberrantfox.kjdautils.api.annotation.CommandSet
import me.aberrantfox.kjdautils.api.dsl.command.commands
import me.aberrantfox.kjdautils.internal.arguments.TextChannelArg

@CommandSet("Information")
fun informationCommands() = commands {
    command("GetInterval") {
        execute(TextChannelArg) {
            val (channel) = it.args

            val interval = channel.slowmode

            it.channel.sendMessage(
                "Channel ${channel.name} has a slow-mode interval of $interval seconds."
            ).queue()
        }
    }
}