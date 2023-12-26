package br.com.helpcsistemas.kafkaconsumer.config

import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.config.SaslConfigs
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import software.amazon.msk.auth.iam.IAMClientCallbackHandler
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@Configuration
class KafkaConsumerConfig(
    private val properties: KafkaProperties
    ) {
    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val configProps = mutableMapOf<String, Any>()
        configProps[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "b-1-public.helpckafka.tmea2x.c20.kafka.us-east-1.amazonaws.com:9198"
        configProps[ConsumerConfig.GROUP_ID_CONFIG] = "pocledger-group"
        configProps[ConsumerConfig.CLIENT_ID_CONFIG] = "8b1c9fa2-858a-437a-9faa-000b38e611b8"
        configProps[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configProps[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java

        configProps[ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG] = "30000"
        configProps[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        configProps[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = false

        configProps[CommonClientConfigs.SECURITY_PROTOCOL_CONFIG] = "SASL_SSL"
        configProps[SaslConfigs.SASL_MECHANISM] = "AWS_MSK_IAM"
        configProps[SaslConfigs.SASL_JAAS_CONFIG] = "software.amazon.msk.auth.iam.IAMLoginModule required;"
        configProps[SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS] = IAMClientCallbackHandler::class.java
        return DefaultKafkaConsumerFactory(configProps)
    }
    @Bean
    fun kafkaListenerContainerFactory() : KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> {
        val listener = ConcurrentKafkaListenerContainerFactory<String, String>()

        listener.consumerFactory = consumerFactory()
        listener.containerProperties.isMissingTopicsFatal = false
        listener.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL

        return listener
    }
}