# Spring-Boot-API
It is a sample sring boot application which demonstrates the creation and working of API using different HTTP methods like GET, POST, PUT and DELETE

### Prerequisites for running the application:

---
Please make sure to have an active instance of MySQL DB running on your system before starting the application.

In case, if you don't have MySQL installed on your system then you could also simply run a container from the mysql image (taken from DockerHub) using the following command:

```docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql```

Once the container is in running state (which you could verify either using docker desktop app or using the command ```docker ps```), you can make use of MySQL Workbench to validate the connection with your running container on port **3306**.

The password specified for mysql DB **root** acoount is **password** :)

---
Once we are done with validating the connection, we need to create the target database as pracDB (the name of the database which I am using in my application).

We can do it either by using MySQL Workbench or by executing the following command in console

```docker exec -it mysqldb mysql -u root -p```

This command prompts for the root password which we specified at the time of running the container. After entering the correct credentials, we get the access to the mysql client where we can execute the SQL query as ```create database pracDB```

We could also create the database with some other name but make sure to change the **spring.datasource.url** property accordingly in application.yaml file.

---
In this method, we have explicitly defined a datasource and a corresponding JdbcTemplate object to perform the setup by referring to the properties defined in the application.yaml file.

The configuration are done within the file J**DBCConfig.java**

---

Before running the application, please locate the **USER.sql** file present in the root directory and execute the command either on your mysql client ar directly onto the MySQL workbench (the steps for accessing which are already present above)

---

### Overview of Content Negotiation
Content negotiation is a process in which a client and a server communicate to agree on the format of the data that will be exchanged between them. In the context of web applications, content negotiation typically involves deciding the format of the response data, such as JSON, XML, HTML, etc., based on the preferences specified by the client in the request headers.

Spring Boot provides built-in support for content negotiation through the use of ```produces``` and ```consumes``` attribute in request mapping annotations.

These attributes allow you to specify the media types (formats) that a particular controller method can produce as a response.

For example,
```
@GetMapping(value = "/get-user-by-id", produces = {"application/json ", "application/xml"}, consumes = {"application/json ", "application/xml"})
```

When sending a request from client to server, we can include an ```Accept``` header to indicate its preference for response format.

In case, the client sends a request with the value of Accept header which is not included in the consumes or produces attribute, then we get an empty response with status code ```406 Not Acceptable```
