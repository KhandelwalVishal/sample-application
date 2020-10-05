# Project Title

Sample Spring boot application to query, add and upload bulk data sets. 

## Getting Started

Just download the code and start the application as spring boot app. The application has an in-memory database (H2) which gets 
auto configure while application start up. The spring auto configuration will also create a table DATASETS to hold the data.

After application start-up, you can see the database tables through console with below link:
http://localhost:8080/h2-console/login.jsp

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:	


In order to test the API endpoints, a single page html is also created in the application at:
http://localhost:8080

In first section of UI, you can upload a csv file to bulk upload data sets. Sample csv file can be found under src/main/resources
Second section can be used to query data based on stock ticker. eg. if you search for stock = 'AA', the table will get populated with data where stock ='AA'.
At the last you can also add a new data set by filling out all the fields and clicking on Add button.
