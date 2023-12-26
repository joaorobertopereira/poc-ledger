package br.com.helpcsistemas.kafkaconsumer.service

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.JsonPayload
import br.com.helpcsistemas.kafkaconsumer.domain.model.TransacaoDynamo
import br.com.helpcsistemas.kafkaconsumer.repository.DynamoRepository
import org.springframework.stereotype.Service

@Service
class DynamoService(private val repository: DynamoRepository) {
    fun saveBatch(payload: JsonPayload) {
        val transacoesDynamo = mutableListOf<TransacaoDynamo>()

        payload.data.lancamentos.forEach { lancamento ->
            val transacaoDynamo = TransacaoDynamo(
                idTransacao          = payload.data.identificadorTransacional,
                idCorrelacao         = payload.data.origemTransacao.identificadorOrigemTransacao,
                dataLancamento       = lancamento.contabil.dataContabilLancamento,
                dataContabil         = lancamento.contabil.dataContabilLancamento,
                origem               = payload.data.origemTransacao.siglaSistemaOrigem,
                dispatchAt           = lancamento.contabil.dataContabilLancamento,
                valorLancamento      = lancamento.valor.valorLancamento,
                valorMinimo          = lancamento.valor.valorMinimo ?: "",
                saldo                = "",  // Você precisa fornecer a lógica apropriada para calcular o saldo
                descricao            = lancamento.extrato.descricao,
                idLancamentoAnterior = lancamento.identificadorLancamentoContaRelacionado ?: ""
            )
            transacoesDynamo.add(transacaoDynamo)
        }

        repository.saveBatch(transacoesDynamo)
    }
}