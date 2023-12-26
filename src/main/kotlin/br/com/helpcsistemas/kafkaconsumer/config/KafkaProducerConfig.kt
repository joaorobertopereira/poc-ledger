package br.com.helpcsistemas.kafkaconsumer.config

import br.com.helpcsistemas.kafkaconsumer.domain.kafka.JsonPayload
import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.config.SaslConfigs
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import software.amazon.msk.auth.iam.IAMClientCallbackHandler

@Configuration
class KafkaProducerConfig {
    @Bean
    fun producerFactory(): ProducerFactory<String, JsonPayload> {
        val configProps = mutableMapOf<String, Any>()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "b-1-public.helpckafka.tmea2x.c20.kafka.us-east-1.amazonaws.com:9198"
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        configProps[ProducerConfig.CLIENT_ID_CONFIG] = "8b1c9fa2-858a-437a-9faa-000b38e611b8"
        configProps[CommonClientConfigs.SECURITY_PROTOCOL_CONFIG] = "SASL_SSL"
        configProps[SaslConfigs.SASL_MECHANISM] = "AWS_MSK_IAM"
        configProps[SaslConfigs.SASL_JAAS_CONFIG] = "software.amazon.msk.auth.iam.IAMLoginModule required;"
        configProps[SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS] = IAMClientCallbackHandler::class.java
        return DefaultKafkaProducerFactory(configProps)
    }
    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, JsonPayload> {
        return KafkaTemplate(producerFactory())
    }
}