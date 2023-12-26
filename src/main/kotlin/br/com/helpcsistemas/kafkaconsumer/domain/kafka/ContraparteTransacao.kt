package br.com.helpcsistemas.kafkaconsumer.domain.kafka

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import kotlinx.serialization.Serializable

@Serializable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ContraparteTransacao(
    @field:JsonProperty("codigo_tipo_conta")
    val codigoTipoConta: String,
    @field:JsonProperty("codigo_ispb")
    val codigoIspb: String,
    @field:JsonProperty("numero_agencia_conta")
    val numeroAgenciaConta: String,
    @field:JsonProperty("numero_conta")
    val numeroConta: String,
    @field:JsonProperty("numero_digito_verificador_conta")
    val numeroDigitoVerificadorConta: String,
    @field:JsonProperty("numero_unico_cliente")
    val numeroUnicoCliente: String,
    @field:JsonProperty("nome_cliente_conta")
    val nomeClienteConta: String,
    @field:JsonProperty("numero_documento_conta")
    val numeroDocumentoConta: String,
    @field:JsonProperty("codigo_tipo_pessoa_conta")
    val codigoTipoPessoaConta: String,
    @field:JsonProperty("codigo_finalidade_transferencia")
    val codigoFinalidadeTransferencia: String,
    @field:JsonProperty("nome_instituicao_financeira")
    val nomeInstituicaoFinanceira: String
)