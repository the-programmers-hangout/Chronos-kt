package dev.supergrecko.chronos.services

import dev.supergrecko.chronos.dataclasses.BotConfiguration
import me.aberrantfox.kjdautils.api.annotation.Service

@Service
open class ConfigService(val config: BotConfiguration) {

}
