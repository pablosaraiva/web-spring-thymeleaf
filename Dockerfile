FROM maven:3.6.3-openjdk-11 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM azul/zulu-openjdk:11
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE=/tmp/target/*.jar
COPY --from=MAVEN_TOOL_CHAIN ${JAR_FILE} app.jar
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/classes/static/ static
ENTRYPOINT ["java","-Xms350m","-Xmx350m","-jar","/app.jar"]