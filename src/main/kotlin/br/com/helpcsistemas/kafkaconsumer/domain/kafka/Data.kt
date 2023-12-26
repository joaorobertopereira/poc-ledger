package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Data(
    @field:JsonProperty("identificador_transacional")
    val identificadorTransacional: String,
    @field:JsonProperty("quantidade_tempo_limite_processamento")
    val quantidadeTempoLimiteProcessamento: Int,
    @field:JsonProperty("conta")
    val conta: Conta,
    @field:JsonProperty("lancamentos")
    val lancamentos: List<Lancamento>,
    @field:JsonProperty("origem_transacao")
    val origemTransacao: OrigemTransacao
)