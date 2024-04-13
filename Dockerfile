FROM eclipse-temurin:20.0.2_9-jdk
LABEL maintainer="pavlovld2007@gmail.com"
COPY build/libs/student_reg-0.0.1-SNAPSHOT.jar /usr/app/demo-app.jar
ENTRYPOINT ["java", "-jar", "/usr/app/demo-app.jar"]
