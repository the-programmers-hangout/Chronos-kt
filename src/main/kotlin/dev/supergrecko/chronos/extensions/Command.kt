package dev.supergrecko.chronos.extensions

import me.aberrantfox.kjdautils.api.dsl.command.Command

private val permissions: MutableMap<Command, PermissionLevel> = mutableMapOf()

internal enum class PermissionLevel(val level: Int) {
    EVERYONE(0),
    ADMIN(10)
}

internal var Command.permission: PermissionLevel
    get() = permissions[this] ?: PermissionLevel.EVERYONE
    set(value) { permissions[this] = value }
