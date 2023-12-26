import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.vaadin") version "24.3.1"
    id("org.jetbrains.kotlin.plugin.allopen") version("1.4.30")
    id("org.jetbrains.kotlin.plugin.serialization") version("1.4.30")
    id("maven-publish")
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("kapt") version "1.9.20"
}

group = "br.com.helpcsistemas"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["vaadinVersion"] = "24.3.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("com.vaadin:vaadin-spring-boot-starter:24.0.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation("org.springframework.kafka:spring-kafka:3.0.4")

    implementation("aws.sdk.kotlin:s3:1.0.0")
    implementation("aws.sdk.kotlin:aws-core-jvm:1.0.19")
    implementation("aws.sdk.kotlin:aws-endpoint-jvm:1.0.19")
    //implementation("aws.sdk.kotlin:sso:1.0.19")
    //implementation("software.amazon.awssdk:dynamodb:2.22.3")
    implementation("com.amazonaws:aws-java-sdk-dynamodb:1.12.623")
    implementation("software.amazon.msk:aws-msk-iam-auth:1.1.9")

    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")



    developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:3.0.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    testImplementation("org.springframework.kafka:spring-kafka-test:3.0.4")
}

dependencyManagement {
    imports {
        mavenBom("com.vaadin:vaadin-bom:${property("vaadinVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

val appArtifactBaseName = "${project.name}"
val appArtifactFileName = "${appArtifactBaseName}-${version}.jar"
val appArtifactPath = "build/libs/${appArtifactFileName}"

publishing {
    publications {
        create<MavenPublication>("maven")
        {
            artifactId = appArtifactBaseName
            artifact(appArtifactPath)
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
