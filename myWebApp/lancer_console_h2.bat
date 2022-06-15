set M2_REPO=C:\Users\d2fde\.m2\repository
set H2_PATH=%M2_REPO%\com\h2database\h2\2.1.212
java -jar %H2_PATH%\h2-2.1.212.jar
REM penser à se déconnecter de la console H2 pour éviter verrou bloquant