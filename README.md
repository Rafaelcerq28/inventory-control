# Product Registration and Inventory Management API

This is a Java project built with Spring Boot that implements a REST API for a product registration and inventory management system. The main objective of this project is to test and showcase skills in web application development using Spring Boot.

The application utilizes the H2 database, however, everyone can test the API by sending a GET request to the `http://localhost:8080/product` endpoint because this project starts reading a data.sql file with some dummy data.

## Instalation
This project was developed usin java 20 make sure you have the Java Development Kit (JDK) installed on your machine. You can check if the JDK is installed by running the following command in the terminal:
```
java -version
```
If the command is not recognized, you need to download and install the JDK before proceeding.

1. Clone this repository to your local machine:
```
https://github.com/Rafaelcerq28/inventory-control.git
```
2. Navigate to the project directory

3. Compile the project using Maven
```
mvn spring-boot:run
```
Now the API will be up and running at `http://localhost:8080`.

## Usage
The API has the following main endpoints:

- POST `/product`: Creates a new product in the system. Send a JSON containing the product information in the request body. Example:
```json
{
  "name": "Product Y",
  "description": "This is a fantastic product",
  "brand": "ABC Corporation",
  "maxQuantity": 100,
  "minQuantity": 10,
  "quantity": 50,
  "weight": 2.5
}
```
- GET `/product`: Retrieves the list of all products registered in the system.

- GET `/product/{id}`: Retrieves the information of a specific product based on the provided ID.

- PUT `/product/{id}`: Updates the information of an existing product based on the provided ID. Send a JSON containing the updated information in the request body.

- DELETE `/product/{id}`: Deletes a product from the system based on the provided ID.

<br>

The API documentation can be accessed through Swagger at the following URL: `http://localhost:8080/swagger-ui.html`.

## Contact
If you have any questions or suggestions about this project, feel free to contact me at rafaelcerq28@gmail.com.
