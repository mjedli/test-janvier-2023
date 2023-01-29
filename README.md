# Test Technique Janvier 2023
Test Technique SpringBoot Janvier 2023


## Installer mongodb et démarrer le service mongodb sous windows

https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/

## Démarrer l'application spring boot

mvnw spring-boot:run

## Instllation

Une fois mongodb installer sur la machine windows, dans notre cas, il faut démarrer le service windows de cette base de données. 

Après on fait un git clone de projet et on se place à la racine pour démarrer le serveur SpringBoot avec la commande prédéfinie précédemment.

## Architecture 

User -> controller -> service -> repository -> mongodb

## Base de données mongodb

Une base de données no sql mongodb

Un modèle de données simple et facile qui correspond à un document mongodb qui représente notre structure de données.

## Les données stockés 

Les informations de l'utilisateur comme le nom le prénom la date de naissance le pays d'origine et le mail qui est unique dans la table user

## Spring AOP

Il est utilisé pour identifier les méthodes de la couche services. Il permet d'écrire des log simple qui donne quelques informations sur ces méthodes comme les entrées sorties de chaque méthode ainsi que le temps d'exécution.

Les tests unitaires

On a tester avec spring la couches controller ainsi que la partie integration qui permet d'exécuter un test de bout en bout.