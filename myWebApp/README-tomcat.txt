Installation de tomcat sous windows:
-----------------------------------
télécharger l'archive "apache-tomcat-9.0.64-windows-x64.zip" depuis le site "tomcat"
et extraire le contenu de cette archive dans c:/serveur ou autre
--> c:/serveurapache-tomcat-9.0.64 avec sous répertoires "bin" , "conf" et "webapps"


Utilisation directe de tomcat sans eclipse:
-------------------------------------------
1) regénérer le .war via run as ... / maven install ou autre
2) recopier target/myWebApp.war  dans le répertoire webapps de TOMCAT
3) vérifier si besoin tomcat/conf/server.xml (8080 ou 8181 si conflit)
4) lancer tomcat/bin/startup.bat en fixant si besoin la variable d'enviromment JAVA_HOME=...chemin---jdk
5) vérifier le démarrage de tomcat via http://localhost:8080
6) tester l'application via http://localhost:8080/myWebApp ou http://localhost:8080/myWebApp/index.html


Lancement indirect de tomcat depuis eclipse:
-------------------------------------------
1) fixer le chemin d'installation tomcat dans la partie "server/runtime environment" de "windows/preferences"
2) Se placer sur "project-explorer/myWebApp" et déclencher "run as .../ run on server"
3) la première fois choisir "manually define new server" et choisir "apache/tomcat 9"
   les prochaines fois choisir "choose an existing server"
4) sélectionner si besoin l'application à démarrer (myWebApp)
5) surveiller les onglets "server" et "console"
6) utiliser l'application dans un navigateur interne ou externe (selon menu "Windows/web browsers")
7) pour arrêter "tomcat lancé depuis eclipse" : onglet "server" et "stop"