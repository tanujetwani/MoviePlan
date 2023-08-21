From openjdk:8
EXPOSE 8088
Add target/MyMoviePlan-0.0.1-SNAPSHOT.war MyMoviePlan-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/MyMoviePlan-0.0.1-SNAPSHOT.war"]