package dev.supergrecko.chronos.services

import dev.supergrecko.chronos.dataclasses.BotConfiguration
import me.aberrantfox.kjdautils.api.annotation.Service
import java.lang.RuntimeException

@Service
internal class ChronoService(private val config: BotConfiguration) {
    init {
        val threads = Runtime.getRuntime().availableProcessors()

        if (threads < 2 && config.enableChronoTimer) {
            throw RuntimeException("Chrono requires two available threads")
        }
    }
}