package br.com.helpcsistemas.kafkaconsumer.consumer

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.JsonPayload
import br.com.helpcsistemas.kafkaconsumer.service.DynamoService
import br.com.helpcsistemas.kafkaconsumer.utils.ConfiguracaoJson
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaConsumer(private val service: DynamoService) {
    companion object {
        val log: Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)
    }
    @KafkaListener(topics = ["\${kafka.topic.name}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun consumer(@Payload payload : String, ack: Acknowledgment) {
        try {
            log.info("Recebendo payload = $payload")
            val configuracaoJsonBean = ConfiguracaoJson()

            val jsonPayload = configuracaoJsonBean.jacksonMapper.readValue(payload, JsonPayload::class.java)

            service.saveBatch(jsonPayload)
        } catch (ex: Throwable) {
            log.error("error=${ex.message}")
        } finally {
            ack.acknowledge()
            log.info("Mensagem processada.")
        }
    }
}