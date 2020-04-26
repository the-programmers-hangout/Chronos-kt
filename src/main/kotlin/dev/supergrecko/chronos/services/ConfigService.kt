package dev.supergrecko.chronos.services

import dev.supergrecko.chronos.dataclasses.BotConfiguration
import me.aberrantfox.kjdautils.api.annotation.Service

@Service
internal open class ConfigService(internal val config: BotConfiguration) {

}
