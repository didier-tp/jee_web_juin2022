NB: une partie de cette application utilise une base de données mysql/mariadb

mysql-connector-java-8.0.22.jar ou un equivalent doit etre placé dans le répertoire lib de tomcat
source possible: $HOME/.m2/ropository/mysql/....  (voir pomx.xml)

configuration de la base de données à préparer:
src\main\config\config_database\mariaDB_ou_mySql\...sql et ...bat
avec besoin d'adapter set MYSQL_HOME=C:\Program Files\MariaDB 10.6 (open with text editor pour .bat)


configuration de l'accès à la base de données à préparer :
src/main/webapp/META-INF/context.xml à éventuellement ajuster (username, password,  url, ...)