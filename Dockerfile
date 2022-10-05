# Installing java 11
FROM openjdk:11

#Copying the local jar to image
ARG APP_HOME="/app/"
RUN mkdir ${APP_HOME}
COPY target/docker-spring-test-0.0.1-SNAPSHOT.jar ${APP_HOME}/docker-spring-test-0.0.1-SNAPSHOT.jar

WORKDIR ${APP_HOME}
EXPOSE 9443
# Running the java (jar) application
CMD ["java", "-jar", "docker-spring-test-0.0.1-SNAPSHOT.jar"]