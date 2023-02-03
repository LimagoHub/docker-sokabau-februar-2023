FROM adoptopenjdk/openjdk11:alpine-jre

ENV TZ="Europe/Stockholm"


RUN addgroup --system 1024 && adduser -S -s /bin/false -G 1024 javauser
LABEL org.opencontainers.image.authors="jowagner@limago.de"
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
#COPY ./data /data


#RUN chown -R javauser:1024 /opt/app
#RUN chmod -R 700 /opt/app
#RUN chown -R javauser:1024 /data
#RUN chmod -R 777 /data
#RUN chmod g+s /data
VOLUME /data
USER javauser

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:h2:/data/db/otherdb;DB_CLOSE_ON_EXIT=FALSE;","-jar","app.jar"]