package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Contabil(
    @field:JsonProperty("codigo_roteiro_contabil")
    val codigoRoteiroContabil: String,
    @field:JsonProperty("codigo_instituicao_financeira")
    val codigoInstituicaoFinanceira: String,
    @field:JsonProperty("numero_agencia_contabil")
    val numeroAgenciaContabil: String,
    @field:JsonProperty("numero_conta_contabil")
    val numeroContaContabil: String,
    @field:JsonProperty("codigo_indice_conta_contabil")
    val codigoIndiceContaContabil: String,
    @field:JsonProperty("indicador_tipo_conta_contabil")
    val indicadorTipoContaContabil: String,
    @field:JsonProperty("texto_complemento_contabil")
    val textoComplementoContabil: String,
    @field:JsonProperty("data_contabil_lancamento")
    val dataContabilLancamento: String
)