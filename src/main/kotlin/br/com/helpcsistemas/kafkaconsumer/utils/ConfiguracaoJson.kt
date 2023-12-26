package br.com.helpcsistemas.kafkaconsumer.utils

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.JsonPayload
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

class ConfiguracaoJson {

    var jacksonMapper = jacksonObjectMapper().registerKotlinModule().setPropertyNamingStrategy(
        PropertyNamingStrategy.SNAKE_CASE
    )
}