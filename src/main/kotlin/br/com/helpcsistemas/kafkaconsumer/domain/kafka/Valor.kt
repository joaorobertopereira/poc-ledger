package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Valor(
    @field:JsonProperty("valor_lancamento")
    val valorLancamento: String,
    @field:JsonProperty("codigo_moeda_transacao")
    val codigoMoedaTransacao: String,
    @field:JsonProperty("valor_minimo")
    val valorMinimo: String?
)
