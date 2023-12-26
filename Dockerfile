FROM alpine:latest AS base
ENV TZ=America/Sao_Paulo
ARG AWS_DEFAULT_REGION
RUN apk --update --no-cache add unzip ca-certificates openjdk11 && update-ca-certificates
COPY ./certs/* /usr/local/share/ca-certificates/
RUN keytool -import -trustcacerts -keystore cacerts -storepass changeit -noprompt -alias ca_interna -file /usr/local/share/ca-certificates/ca_interna.crt && \
    keytool -import -trustcacerts -keystore cacerts -storepass changeit -noprompt -alias ca_cert -file /usr/local/share/ca-certificates/ca_cert.crt && \
    keytool -import -trustcacerts -keystore cacerts -storepass changeit -noprompt -alias ca_root -file /usr/local/share/ca-certificates/ca_root.crt && \
    keytool -import -trustcacerts -keystore cacerts -storepass changeit -noprompt -alias R0142 -file /usr/local/share/ca-certificates/R0142.crt && \
    keytool -import -trustcacerts -keystore cacerts -storepass changeit -noprompt -alias ca_bundle -file /usr/local/share/ca-certificates/ca_bundle.crt && \
    update-ca-certificates -f
ADD ./app/*.jar /app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${ENV:prod}","-XX:+UseSerialGC","-jar","/app.jar"]