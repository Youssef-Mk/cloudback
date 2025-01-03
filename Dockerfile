# Étape 1 : Utiliser une image Java officielle
FROM openjdk:17-jdk-slim AS build

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré
COPY target/simsa-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build target/simsa-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port 8080
EXPOSE 8080

# Étape 5 : Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

