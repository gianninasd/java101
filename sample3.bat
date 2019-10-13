@ECHO OFF
REM Windows batch file to launch Java application

java -Djava.util.logging.config.file=out\production\sample3\logging.properties -cp out\production\sample3 dg.sample3.FileParser %1