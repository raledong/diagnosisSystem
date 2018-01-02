FROM java:8
EXPOSE 9090
ADD /target/diagnosisSystem_spring-1.0-SNAPSHOT.jar diagnosis.jar
ENTRYPOINT ["java", "-jar", "diagnosis.jar"]