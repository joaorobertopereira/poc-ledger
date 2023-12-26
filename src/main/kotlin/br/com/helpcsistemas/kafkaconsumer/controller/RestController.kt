package br.com.helpcsistemas.kafkaconsumer.controller

import br.com.helpcsistemas.kafkaconsumer.producer.KafkaProducer
import br.com.helpcsistemas.kafkaconsumer.service.PayloadService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(private val producer: KafkaProducer, private val payloadService: PayloadService) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(RestController::class.java)
    }
    @PostMapping(value = ["/send/{quantidadeLancamentos}"])
    fun sendMessage(@PathVariable quantidadeLancamentos: Int) {
        log.info("Inicio do envio de mensagem")
        val jsonPayload = payloadService.criarObjetoComQuantidadeDeLancamentos(quantidadeLancamentos)

        producer.sendMessage(jsonPayload)
    }
}