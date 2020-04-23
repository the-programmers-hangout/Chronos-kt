FROM maven:3.6.0-jdk-11-slim AS build

COPY pom.xml /pom.xml
COPY src /src/

RUN mvn clean package -f /pom.xml

FROM openjdk:12

ENV DISCORD_TOKEN=INVALID_TOKEN

COPY --from=build /target/Chronos-jar-with-dependencies.jar /Chronos.jar

CMD /usr/bin/java -jar /Chronos.jar $DISCORD_TOKEN