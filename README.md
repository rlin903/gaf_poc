this is a POC to shaow case a quick springboot application to access database to performing CRU(no D) operation.

to run, go in to the project directory, for example C:\IdeaProject\boot\gaf_poc, first
mvn clean compile package spring-boot:run
wait sometime until build success, the application will start a localhost:8080/contacts

path to embeded in memory db, make sure the the jdbc URl is JDBC URL: jdbc:h2:mem:testdb
http://localhost:8080/h2-console/

path to poc application
http://localhost:8080/contacts/

path to swagger UI for testing
http://localhost:8080/swagger-ui.html#/