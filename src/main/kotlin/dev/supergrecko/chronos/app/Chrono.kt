package dev.supergrecko.chronos.app

import net.dv8tion.jda.api.entities.Message

internal object Chrono {
    private val pool: Pool<Message> = Pool(256)
}