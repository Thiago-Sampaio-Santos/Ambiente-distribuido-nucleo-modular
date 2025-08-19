# Etapa de build
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -e -DskipTests clean package

# Etapa de runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
# Aqui copiamos o jar final — cuidado para não falhar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 50051 1099 7000 7100
ENTRYPOINT ["java","-jar","/app/app.jar"]
