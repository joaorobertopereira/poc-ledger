package br.com.helpcsistemas.kafkaconsumer.service

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.*
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class PayloadService {
    fun criarObjetoComQuantidadeDeLancamentos(quantidadeLancamentos: Int): JsonPayload {
        val jsonPayload = JsonPayload(
            Data(
                identificadorTransacional = java.util.UUID.randomUUID().toString(),
                quantidadeTempoLimiteProcessamento = 1000,
                conta = Conta(
                    identificadorUnicoConta = java.util.UUID.randomUUID().toString(),
                    numeroTitularidadeConta = "1"
                ),
                lancamentos = criarLancamentosAleatorios(quantidadeLancamentos),
                origemTransacao = OrigemTransacao(
                    codigoTipoOperacao = "PIX_RECEPCAO",
                    siglaSistemaOrigem = "X0",
                    identificadorOrigemTransacao = "E987234982739847293784DOIASDML93",
                    identificadorProduto = "PIX",
                    canal = "Internet",
                    complementoCanal = "ApplePay"
                )
            )
        )

        return jsonPayload
    }
    fun criarLancamentosAleatorios(quantidade: Int): List<Lancamento> {
        val lancamentos = mutableListOf<Lancamento>()

        for (i in 1..quantidade) {
            val tipoMovimentacao = if (Random.nextBoolean()) "CREDITO" else "DEBITO"
            val valorLancamento = String.format("%.2f", Random.nextDouble(1000.0, 10000.0))
            val valorMinimo = String.format("%.2f", Random.nextDouble(1000.0, 10000.0))
            val dataContabil = LocalDate.now().toString()

            val lancamento = Lancamento(
                tipoMovimentacaoConta = tipoMovimentacao,
                identificadorLancamentoConta = java.util.UUID.randomUUID().toString(),
                identificadorLancamentoContaRelacionado = java.util.UUID.randomUUID().toString(),
                codigoComposicaoSaldoConta = "A",
                codigoSufixoConta = Random.nextInt(100000),
                indicadorLancamentoCompulsorioOcorrencia = Random.nextInt(100000),
                valor = Valor(
                    valorLancamento = valorLancamento,
                    codigoMoedaTransacao = "BRL",
                    valorMinimo = valorMinimo
                ),
                contabil = Contabil(
                    codigoRoteiroContabil = Random.nextInt(100000).toString(),
                    codigoInstituicaoFinanceira = Random.nextInt(10000).toString(),
                    numeroAgenciaContabil = Random.nextInt(10000).toString(),
                    numeroContaContabil = Random.nextInt(10000).toString(),
                    codigoIndiceContaContabil = Random.nextInt(10000).toString(),
                    indicadorTipoContaContabil = "C",
                    textoComplementoContabil = Random.nextInt(100000).toString(),
                    dataContabilLancamento = dataContabil
                ),
                extrato = Extrato(
                    codigoMotivoLancamento = Random.nextInt(100000).toString(),
                    textoComplementoLancamento = dataContabil,
                    inficadorLancamentoVisivelContaCliente = Random.nextBoolean(),
                    codigoAgrupamentoLancamento = "ITI",
                    descricao = "DESCRICAO OPERACAO"
                ),
                contraparteTransacao = ContraparteTransacao(
                    codigoTipoConta = "P",
                    codigoIspb = "341",
                    numeroAgenciaConta = Random.nextInt(10000).toString(),
                    numeroConta = Random.nextInt(10000).toString(),
                    numeroDigitoVerificadorConta = Random.nextInt(10).toString(),
                    numeroUnicoCliente = Random.nextInt(1000000000).toString(),
                    nomeClienteConta = "Nome Aleatório",
                    numeroDocumentoConta = Random.nextInt(1000000000).toString(),
                    codigoTipoPessoaConta = "FISICA",
                    codigoFinalidadeTransferencia = Random.nextInt(10).toString(),
                    nomeInstituicaoFinanceira = "BCO SANTANDER (BRASIL) S.A."
                )
            )
            lancamentos.add(lancamento)
        }
        return lancamentos
    }
}