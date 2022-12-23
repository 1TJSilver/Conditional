FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD build/libs/HW-7_1_1_1-Conditional-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","myapp.jar"]