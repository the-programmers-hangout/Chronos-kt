package dev.supergrecko.chronos.preconditions

import dev.supergrecko.chronos.extensions.PermissionLevel
import dev.supergrecko.chronos.extensions.permission
import dev.supergrecko.chronos.services.ConfigService
import me.aberrantfox.kjdautils.api.annotation.Precondition
import me.aberrantfox.kjdautils.internal.command.Fail
import me.aberrantfox.kjdautils.internal.command.Pass
import me.aberrantfox.kjdautils.internal.command.precondition

@Precondition(100)
internal fun hasPermission(config: ConfigService) = precondition {
    val admin = it.message.member
        ?.roles
        ?.any { role -> config.config.adminRole == role.name }

    val level = if (admin != true)
        PermissionLevel.EVERYONE else
        PermissionLevel.ADMIN

    val required = it.container[it.commandStruct.commandName]?.permission
        ?: PermissionLevel.ADMIN

    if (level >= required) {
        return@precondition Pass
    }

    return@precondition Fail("You do not have access to use this command.")
}
