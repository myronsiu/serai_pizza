# serai_pizza

# services

Built using Maven, Java 11, Spring boot

Receiver - receive order and send to another service for storage

Persist - store received order to database

# Init Project
Both service could be started using Maven:

mvn clean test spring-boot:run


# API - Receiver
Send Random Order:

GET http://localhost:4587/order/random

Get Order By ID:

GET http://localhost:4587/order/{id}

Sample ID: 1

Submit Order:

POST http://localhost:4587/order/

Sample Body:
{
   "firstName": "Sally",
	"lastName": "Lee",
	"contactNumber": "98422432",
	"email": "abc@gmail.com",
	"address": "Mongkok, Hong Kong",
	"pizzaList": [
        {
            "name": "Good pizza",
            "quantity": 2
        },
        {
            "name": "Very Good pizza",
            "quantity": 3
        }
    ]
}


# API - Persist
Get Order By ID:

GET http://localhost:4587/order/{id}

Sample ID: 1

Submit Order:

POST http://localhost:4588/order/

Sample Body:
{
   "firstName": "Sally",
	"lastName": "Lee",
	"contactNumber": "98422432",
	"email": "abc@gmail.com",
	"address": "Mongkok, Hong Kong",
	"pizzaList": [
        {
            "name": "Good pizza",
            "quantity": 2
        },
        {
            "name": "Very Good pizza",
            "quantity": 3
        }
    ]
}
