FROM adoptopenjdk/openjdk12:x86_64-alpine-jre-12.0.2_10

EXPOSE 8080

ADD ./build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]