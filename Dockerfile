FROM openjdk:19-jdk-slim
RUN mkdir /app
COPY ./build/libs/ataxx-all.jar /app
WORKDIR /app
ENTRYPOINT ["java", "-jar", "ataxx-all.jar"]