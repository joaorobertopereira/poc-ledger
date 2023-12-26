package br.com.helpcsistemas.kafkaconsumer.domain.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "tbx0100_ledger_poc_map")
data class TransacaoDynamo(
    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "id_transacao")
    var idTransacao: String,
    @DynamoDBAttribute(attributeName = "id_correlacao")
    var idCorrelacao: String,
    @DynamoDBAttribute(attributeName = "data_lancamento")
    val dataLancamento: String,
    @DynamoDBAttribute(attributeName = "data_contabil")
    val dataContabil: String,
    @DynamoDBAttribute(attributeName = "origem")
    val origem: String,
    @DynamoDBAttribute(attributeName = "dispatch_at")
    val dispatchAt: String,
    @DynamoDBAttribute(attributeName = "valor_lancamento")
    val valorLancamento: String,
    @DynamoDBAttribute(attributeName = "valor_minimo")
    val valorMinimo: String,
    @DynamoDBAttribute(attributeName = "saldo")
    var saldo: String,
    @DynamoDBAttribute(attributeName = "descricao")
    var descricao: String,
    @DynamoDBAttribute(attributeName = "id_lancamento_anterior")
    var idLancamentoAnterior: String
)
