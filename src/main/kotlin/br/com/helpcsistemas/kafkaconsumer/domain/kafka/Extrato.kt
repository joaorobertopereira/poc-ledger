package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Extrato(
    @field:JsonProperty("codigo_motivo_lancamento")
    val codigoMotivoLancamento: String,
    @field:JsonProperty("texto_complemento_lancamento")
    val textoComplementoLancamento: String,
    @field:JsonProperty("inficador_lancamento_visivel_conta_cliente")
    val inficadorLancamentoVisivelContaCliente: Boolean,
    @field:JsonProperty("codigo_agrupamento_lancamento")
    val codigoAgrupamentoLancamento: String,
    @field:JsonProperty("descricao")
    val descricao: String
)
