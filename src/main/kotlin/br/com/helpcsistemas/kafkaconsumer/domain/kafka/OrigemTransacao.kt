package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class OrigemTransacao(
    @field:JsonProperty("codigo_tipo_operacao")
    val codigoTipoOperacao: String,
    @field:JsonProperty("sigla_sistema_origem")
    val siglaSistemaOrigem: String,
    @field:JsonProperty("identificador_origem_transacao")
    val identificadorOrigemTransacao: String,
    @field:JsonProperty("identificador_produto")
    val identificadorProduto: String,
    @field:JsonProperty("canal")
    val canal: String,
    @field:JsonProperty("complemento_canal")
    val complementoCanal: String
)