package br.com.helpcsistemas.kafkaconsumer.producer

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.JsonPayload
import br.com.helpcsistemas.kafkaconsumer.utils.ConfiguracaoJson
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.math.log

@Component
class KafkaProducer(private val kafaTemplate: KafkaTemplate<String, JsonPayload>,
                    @Value("\${kafka.topic.name}") private val topic: String) {
    companion object {
        val log: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)
    }
    fun sendMessage(jsonPayload: JsonPayload) {
        log.info("Enviando mensagem ao tópico $topic.")
        val producerRecord = ProducerRecord(topic, jsonPayload.data.identificadorTransacional, jsonPayload)
        kafaTemplate.send(producerRecord)
        val configuracaoJsonBean = ConfiguracaoJson()
        val jsonString = configuracaoJsonBean.jacksonMapper.writeValueAsString(jsonPayload)
        log.info("Mensagem enviada.")
        log.info("Payload Enviado   = $jsonString")
    }
}