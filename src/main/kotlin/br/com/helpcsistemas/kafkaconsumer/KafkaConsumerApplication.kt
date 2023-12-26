package br.com.helpcsistemas.kafkaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class KafkaConsumerApplication

fun main(args: Array<String>) {
    runApplication<KafkaConsumerApplication>(*args)
}
