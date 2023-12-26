package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Lancamento(
    @field:JsonProperty("tipo_movimentacao_conta")
    val tipoMovimentacaoConta: String,
    @field:JsonProperty("identificador_lancamento_conta")
    val identificadorLancamentoConta: String,
    @field:JsonProperty("identificador_lancamento_conta_relacionado")
    val identificadorLancamentoContaRelacionado: String,
    @field:JsonProperty("codigo_composicao_saldo_conta")
    val codigoComposicaoSaldoConta: String,
    @field:JsonProperty("codigo_sufixo_conta")
    val codigoSufixoConta: Int,
    @field:JsonProperty("indicador_lancamento_compulsorio_ocorrencia")
    val indicadorLancamentoCompulsorioOcorrencia: Int,
    @field:JsonProperty("valor")
    val valor: Valor,
    @field:JsonProperty("contabil")
    val contabil: Contabil,
    @field:JsonProperty("extrato")
    val extrato: Extrato,
    @field:JsonProperty("contraparte_transacao")
    val contraparteTransacao: ContraparteTransacao
)