FROM openjdk:11
COPY ./target/hw1-0.0.1-SNAPSHOT.jar hw1.jar

EXPOSE 8000

RUN mvn -DskipTests clean package

CMD ["java", "-jar", "hw1.jar"]