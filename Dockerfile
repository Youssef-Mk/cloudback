# Étape 1 : Utiliser une image Java officielle compatible avec Java 21
FROM openjdk:21-jdk-slim

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le fichier JAR généré
COPY target/simsa-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port 8080
EXPOSE 8082

# Étape 5 : Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
