# Digicode

### Contexte

La M2L met à disposition des ligues un site web d'information sur le digicode permettant l'accès à la M2L
ainsi que sur la clé Wifi "visiteurs". Le système de réservation donne également le digicode du jour dans le
compte-rendu de réservation envoyé automatiquement par mail.

### Le projet

L'objectif est de fournir aux utilisateurs la possibilité de récupérer des informations ( digicode, clé "wifi" ) par
une application dont vous avez la charge du développement.
Les utilisateurs doivent donc pouvoir disposer de ces informations à l'extérieur du site. Ainsi, une application
mobile semble répondre à ce type de besoin. 

### Solution Informatique
* Récupération des données via un fichier JSON
* Utilisation d'un calendrier pour gérer les dates de reservation
* Liste de salle en fonction du choix de la date
* Affichage des codes et d'un Qrcode pour faciliter le partage 

### Notions utilisées
* Repository (composant architectural qui agit comme un pont entre différentes sources de données)
* Adaptateur (composant utilisé pour lier des données à des vues) -> agit comme un pont entre une liste d'éléments, et la vue qui affiche ces éléments
* ViewHolder (conserve les références aux vues et les réutilise pour afficher différents éléments de la liste)
* Context (représente diverses informations sur l'environnement de l'application en cours d'exécution)
* Intention (action à effectuer pour communiquer entre les différents composants d'une application Android)

### Arborescence
```
.
└── com.btssio.ozenne.digicode/
    ├── assets/
    │   └── data.json
    ├── main/
    │   ├── conroller/
    │   │   ├── DataActivity.kt
    │   │   ├── ListeSalleActivity.kt
    │   │   └── MainActivity.kt
    │   ├── model/
    │   │   ├── Code.kt
    │   │   └── Salle_Adapter.kt
    │   └── repository/
    │       └── CodeRepository
    └── res/
        ├── drawable/
        │   ├── logo.png
        │   └── m2l_img.png
        ├── layout/
        │   ├── activity_code.xml
        │   ├── activity_liste_salle.xml
        │   ├── activity_main.xml
        │   └── item_salle.xml
        └── values/
            ├── colors.xml
            └── strings.xml
```
### Apperçus du projet

<img src="https://github.com/medhidev/Digicode/blob/main/presentation/1.jpg" alt="Description de l'image" width="200" height="450">‎ ‎ ‎ ‎ <img src="https://github.com/medhidev/Digicode/blob/main/presentation/2.jpg" alt="Description de l'image" width="200" height="450">‎‎ ‎ ‎ ‎ <img src="https://github.com/medhidev/Digicode/blob/main/presentation/3.jpg" alt="Description de l'image" width="200" height="450">
