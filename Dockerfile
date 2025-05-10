# Use Java 17 base image
FROM openjdk:17-jdk-slim

# Create app directory
WORKDIR /app

# Copy the jar file
COPY target/jobportal-1.0.0.jar app.jar


# Expose port 8080
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]