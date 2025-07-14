# Stage 1: build the application
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build with Maven (skip tests for faster builds; remove -DskipTests if tests are needed)
RUN mvn clean package -DskipTests

# Stage 2: run the application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=build /app/target/*.jar app.jar

# If your app requires environment variables or specific JVM flags, optionally set them here:
# ENV JAVA_OPTS="-Xms512m -Xmx512m"
# ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port your application uses (example: 8080)
EXPOSE 8080

# Entry point
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
