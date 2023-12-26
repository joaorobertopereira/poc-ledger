package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class JsonPayload(
    @field:JsonProperty("data")
    val data: Data
)