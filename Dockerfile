FROM bellsoft/liberica-openjdk-alpine-musl:11.0.12-7
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} ab_app.jar
ENTRYPOINT ["java", "-jar", "ab_app.jar"]