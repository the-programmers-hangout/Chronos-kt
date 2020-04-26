package dev.supergrecko.chronos.dataclasses

import me.aberrantfox.kjdautils.api.annotation.Data

@Data("config/config.json")
internal data class BotConfiguration(
    val adminRole: String = "Admin",
    val enableChronoTimer: Boolean = true
)
