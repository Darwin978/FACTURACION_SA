FROM openjdk:17-jdk-slim
LABEL authors="DGONZALEZ"

COPY target/practica-0.0.1.jar /app/practica-0.0.1.jar

CMD ["java", "-jar", "/app/practica-0.0.1.jar"]

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080