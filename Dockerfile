FROM openjdk:latest
ADD target/tokenList-0.0.1-SNAPSHOT.jar tokenList
ENTRYPOINT ["java", "-jar", "tokenList"]
EXPOSE 1000
