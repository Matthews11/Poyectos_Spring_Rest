
FROM openjdk:18.0.2.1-oracle

#creacion de carpeta
WORKDIR /app

#copia el jar a la carpeta raiz
COPY ./target/biblioteca-0.0.1-SNAPSHOT.jar .

#puerto de despliegue
EXPOSE 6666

#referencia del jar
ENTRYPOINT ["java","-jar", "biblioteca-0.0.1-SNAPSHOT.jar"]