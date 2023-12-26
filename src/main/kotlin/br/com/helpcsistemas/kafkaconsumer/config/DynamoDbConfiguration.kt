package br.com.helpcsistemas.kafkaconsumer.config

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDbConfiguration {
    @Value("\${aws.dynamodb.endpoint}")
    private val dynamoDbEndpoint: String? = null

    @Value("\${aws.dynamodb.accessKey}")
    private val awsAccessKey: String? = null

    @Value("\${aws.dynamodb.secretKey}")
    private val awsSecretKey: String? = null


    @Bean
    fun dynamoDBMapper(): DynamoDBMapper {
        return DynamoDBMapper(amazonDynamoDb())
    }

    private fun amazonDynamoDb(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, "us-east-1")
            )
            .withCredentials(amazonDynamoDBCredentials()).build()
    }

    private fun amazonDynamoDBCredentials(): AWSCredentialsProvider {
        return AWSStaticCredentialsProvider(BasicAWSCredentials(awsAccessKey, awsSecretKey))
    }
}
