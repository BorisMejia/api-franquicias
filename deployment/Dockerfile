FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN addgroup -S spring && adduser -S appuser -G spring
COPY applications/app-service/build/libs/*.jar api-franquicias.jar
RUN chown appuser:spring api-franquicias.jar
ENV JAVA_OPTS=" -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
USER appuser
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar api-franquicias.jar" ]
