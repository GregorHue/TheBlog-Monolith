| Build Status  | 
|---|
|[![CircleCI](https://circleci.com/gh/GregorHue/TheBlog-Monolith.svg?style=svg&circle-token=39d718716aa5c56cf29460c6ac00e25d1f3b2a90)](https://circleci.com/gh/GregorHue/TheBlog-Monolith)|
# TheBlog-Monolith
A Jakarta EE implementation of a demo blog

## Prerequisites

As a prerequisite JAVA 8(u162+) or JAVA 11(11.0.4+) and Maven 3.3.9 or above have to be installed on your computer.

## Installation 

Download or copy the repository into a directory of your choice. Change into this directory, possibly unzip the content and

type on the command line:
   
* `mvn clean verify`

## Run

In order to run the application type on the command line:

* `mvn payara-micro:start` 

The development server will serve the application under the base url `localhost:8080/the-blog/`.

## IDE

You can work with an IDE of your choice. Please ensure that a Lombok plugin is installed. Note that annotation processing
has to be enabled for Lombok and MapStruct.

## Functionality
This application provides the common functionality of a blog and includes a roles-based user management. 

In detail:

* An anonymous user can read posts and comments.

* A logged-in user can write posts and comments.

* A logged-in user can vote on posts and comments.

* Only the user himself can edit his user profile.

* Only the author of a post or a comment (and the admin) can edit the post or comment, respectivly.

* Only the admin can delete a post, a comment or a user.

* Only the admin can look at the list of users.

* Two predifined users:

  * username `user` with password `user` and role `ROLE_USER`
  
  * username `admin` with password `admin` and `ROLE_ADMIN`

* New users are allowed to sign up.

## Technology

* Monolithic JakartaEE application

* Java Server Faces as view technology

* Multi tier architecture

* In-memory pre-populated H2 database

* Embedded Payara Micro server

* UI libraries Bootsfaces and Primefaces

* Responsive layout
