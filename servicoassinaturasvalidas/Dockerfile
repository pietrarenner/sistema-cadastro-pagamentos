FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /workspace/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:17-jre-alpine AS final
WORKDIR /workspace/app
COPY --from=build /workspace/app/target/*.jar /workspace/app/app.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "/workspace/app/app.jar"]