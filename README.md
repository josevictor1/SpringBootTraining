# Spring Boot Training - A Simple Restful Service Example

The onjective of this project is construct a simple restful service to improve the knowledge in the Spring framework.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Prerequisites

*[JDK](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
*[Intellij](https://www.jetbrains.com/idea/) or [Eclipse](http://www.eclipse.org)
*[Maven](https://maven.apache.org)
*[Postman](https://www.getpostman.com)

## Description

This project implements the simple HTTP functions:

* GET - the get method gives "something" to us. Here we have to methods based on GET:
**getAccounts() - return a list of accounts
**getSelectedAccounts() - gave a "id" return the account in the list of accounts that have the same id

* POST - send "something" to "someplace" or "someone":
**addAccount(Account account) - add one account in the accounts' list

* DELETE - delete something in the "some place":
**deleteAccount(int id) - recives an id and delete the account that it behind

* PUT- update "someone" in "someplace" based on id:
**updateAccount(Account account,int id) - recives the changed object and the id


## Examples
To run the examples use postman. Local path: http://localhost:8080/

### LIST

command:"http://localhost:8080/listAccounts" or "http://localhost:8080/listAccounts/2"(i.e to get the account with id 2)

Rerturn:
{
	"id": 1,
	"name": "teste",
	"description": "teste"
}


### ADD

command:"http://localhost:8080/addAccount"

Body:

{
	"id": 3,
	"name": "teste",
	"description": "teste"
}

Return: 
"Account added"

### DELETE

command:"http://localhost:8080/deleteAccount/2" (i.e to change the account with id 2)

Return:
 "The account number: 2 not founded"(if account doens't exist)
        
 "The account number:2 with user's name:teste was delete "

### UPDATE

command:"http://localhost:8080/updateAccount/2"(i.e to change the account with id 2)

Body:

{
	"id": 2,
	"name": "teste",
	"description": "teste changed"
}


Return:
 "The account number: 2 not founded";(if account doens't exist)
       
 "The account number: 2 with user's name:teste was changed.";


### Java Notations

@RequestMapping(value = "/addres", method = GET) - map method to /addres and specifies the method's type, "method = GET"(GET in this case) 
@PathVariable("variable") = specifie the variable that will be recived by the method
@RequestBody Type object - specifie that some object of some type will be recived by the method 
@RestController - identifie the class as a Controller configured by the class
@SpringBootApplication - identifie the class as a starter of the spring boot application

## Authors

* **José Victor Pereira Costa**  





