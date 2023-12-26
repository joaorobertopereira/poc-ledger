package br.com.helpcsistemas.kafkaconsumer.repository

import br.com.helpcsistemas.kafkaconsumer.domain.model.TransacaoDynamo
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import org.springframework.stereotype.Repository

@Repository
class DynamoRepository(private val dynamoDBMapper: DynamoDBMapper) {
    fun save(transacao: TransacaoDynamo) {
        dynamoDBMapper.save(transacao)
    }
    fun saveBatch(transacoes: List<TransacaoDynamo?>) {
        dynamoDBMapper.batchSave(transacoes)
    }

    fun findById(idTransacao: String): TransacaoDynamo? {
        return dynamoDBMapper.load(TransacaoDynamo::class.java, idTransacao)
    }

    fun update(transacao: TransacaoDynamo) {
        dynamoDBMapper.save(transacao, DynamoDBMapperConfig.builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build())
    }

    fun delete(transacao: TransacaoDynamo) {
        dynamoDBMapper.delete(transacao)
    }



}