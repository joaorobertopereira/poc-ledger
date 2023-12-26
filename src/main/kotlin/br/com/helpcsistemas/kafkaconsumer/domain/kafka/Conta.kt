package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Conta(
    @field:JsonProperty("identificador_unico_conta")
    val identificadorUnicoConta: String,
    @field:JsonProperty("numero_titularidade_conta")
    val numeroTitularidadeConta: String,
)