\# TP Docker – RentalService



Ce projet a été réalisé dans le cadre du TP Docker.  

L’objectif est de builder une application Spring Boot, la tester en local, la conteneuriser avec Docker et publier l’image sur Docker Hub.



---



\## Récupération du projet et configuration Git



Clonage du dépôt d’origine :



```bash

git clone https://github.com/charroux/ingnum

cd ingnum

Modification du dépôt distant pour pointer vers le dépôt personnel :



bash

Copier le code

git remote remove origin

git remote add origin https://github.com/dynanoir/ingnum\_tom.git

git branch -M main

git push -u origin main

Vérification de Java

Version de Java utilisée :



bash

Copier le code

java --version

OpenJDK 21 (Temurin)



Build et test du projet sans Docker

Placement dans le dossier du projet :



bash

Copier le code

cd RentalService

Build du projet avec Gradle :



bash

Copier le code

gradlew.bat build

Lancement de l’application sans Docker :



bash

Copier le code

java -jar build/libs/RentalService-0.0.1-SNAPSHOT.jar

Test dans le navigateur :



bash

Copier le code

http://localhost:8080/bonjour

Résultat attendu :



nginx

Copier le code

Bonjour

Création du Dockerfile

Le fichier Dockerfile est placé dans le dossier RentalService.



Contenu du Dockerfile :



dockerfile

Copier le code

FROM eclipse-temurin:21



VOLUME /tmp



EXPOSE 8080



ADD ./build/libs/RentalService-0.0.1-SNAPSHOT.jar app.jar



ENTRYPOINT \["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

Build de l’image Docker

Création de l’image Docker :



bash

Copier le code

docker build -t rentalservice-tom .

Lancement de l’application avec Docker

Lancement du conteneur Docker :



bash

Copier le code

docker run -p 8080:8080 rentalservice-tom

Test dans le navigateur :



bash

Copier le code

http://localhost:8080/bonjour

Résultat attendu :



nginx

Copier le code

Bonjour

Publication sur Docker Hub

Connexion à Docker Hub :



bash

Copier le code

docker login

Tag de l’image :



bash

Copier le code

docker tag rentalservice-tom tonPseudoDockerHub/rentalservice-tom:latest

Publication de l’image :



bash

Copier le code

docker push tonPseudoDockerHub/rentalservice-tom:latest





\*\*Étape finale\*\* :



```bat

git add README.md

git commit -m "Ajout du README du TP Docker"

git push

