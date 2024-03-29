FROM openjdk:17-ea-jdk-oracle

ARG JAR_FILE=build/libs/bot-0.0.1-SNAPSHOT.jar
ARG PROP=build/libs/application-prod.yaml

WORKDIR /opt/app/bot

COPY ${JAR_FILE} bot.jar
COPY ${PROP} prop.yaml

ENTRYPOINT ["java", "-jar", "bot.jar", "--spring.config.location=file:./prop.yaml"]