<h1 align = "center"> Music Streaming Service </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=17-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.1.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
  
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>
   
This project is a Music Streaming Service API that allows users to manage songs and playlists. It provides endpoints for CRUD operations on songs and playlists, with additional features for admin

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Model

<br>

* User Model
```
Id : integer
username : String
password : string
email : string
age : Integer
role : Role(ManyToOne)
playlist : Playlist(OneToOne)
```

* Playlist Model
```
playlistId : Long
playListName
songs : songs(OneToMany)
User : user(OneToOne)
```

* Song Model
```
SongId : Long
SongName : String
Genre : Enum
Duration : Double
Artist : String 
Album : String
SongLink : String
```


* Authentication Token 
```
tokenId : Long
token : string
tokenCreationDate : LocalDate
@OneToOne 
user : User
```

* Role Token 
```
roleId : Long
roleType : string
roleDescription : string
```

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points 

The following endpoints are available in the API:



```
http://localhost:8080/role/abhi@headadmin.com


http://localhost:8080/user/signup
{
  "userName": "Admin",
  "password": "Ab@123",
  "email": "abc@admin.com",
  "age" : 25,
  "role": {
    "roleId": 1
  }
}


http://localhost:8080/user/signup

{
  "userName": "Abc",
  "password": "Ab@123",
  "email": "abc@gmail.com",
  "age": 15,
  "role": {
    "roleId": 2
  }
}


http://localhost:8080/user/signin

{
  "email": "abc@gmail.com",
  "password": "Ab@123"
}

http://localhost:8080/user/signin

{
  "email": "abc@admin.com",
  "password": "Ab@123"
}

http://localhost:8080/songs?email=abc@admin.com&token=4b329a50-3220-4756-8a82-efa254c22817

http://localhost:8080/playList?email=abc@gmail.com&token=73491092-862e-468c-b205-913d0ca2d045

http://localhost:8080/playList/add/3?email=abc@gmail.com&token=73491092-862e-468c-b205-913d0ca2d045

http://localhost:8080/playList/delete/3?email=abc@gmail.com&token=73491092-862e-468c-b205-913d0ca2d045

http://localhost:8080/songs?email=abc@admin.com&token=4b329a50-3220-4756-8a82-efa254c22817

http://localhost:8080/songs/1?email=abc@admin.com&token=4b329a50-3220-4756-8a82-efa254c22817

http://localhost:8080/songs/3?email=abc@admin.com&token=4b329a50-3220-4756-8a82-efa254c22817

http://localhost:8080/playList?email=abc@gmail.com&token=4b329a50-3220-4756-8a82-efa254c22817
```


<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

# Documentation

implement a Music Streaming application using Spring Boot. The code you shared includes several controller classes (PlayListController, RoleController, SongController) and other supporting classes (DTOs, models, repositories, services).

Here is a breakdown of the code you provided:

1. `PlayListController` class: This class is a Spring RestController that handles HTTP requests related to playlists. It has methods for adding a playlist, getting a playlist, deleting a playlist, updating a playlist, and deleting a song from a playlist.

2. `RoleController` class: This class is a Spring RestController that handles HTTP requests related to roles. It has a method for adding a role for a given email.

3. `SongController` class: This class is a Spring RestController that handles HTTP requests related to songs. It has methods for adding songs, getting all songs, deleting a song, and updating a song.

4. DTOs (Data Transfer Objects): These classes (`SignInInput`, `SignInOutput`, `SignUpInput`, `SignUpOutput`) represent the data transferred between the client and server. They contain fields and annotations for data validation.

5. Models: These classes (`AuthenticationToken`, `Genre`, `PlayList`, `Role`, `Song`, `User`) represent the entities in your application. They are annotated with JPA annotations to define the database schema.

6. Repositories: These interfaces (`IPlayListRepo`, `IRoleRepo`, `ISongRepo`, `ITokenRepo`, `IUserRepo`) extend the Spring Data JPA `JpaRepository` interface and provide methods for interacting with the database.

7. Services: These classes (`PlayListService`, `RoleService`, `SongService`, `TokenService`, `UserService`) contain the business logic of your application. They use the repositories to perform CRUD operations on the entities.

#### Overall, the code structure follows the MVC (Model-View-Controller) pattern commonly used in Spring Boot applications. The controllers handle HTTP requests, the services handle the business logic, and the repositories handle the database operations.
---
## Author

👤 **Rudra Pratap Singh**

* GitHub: [Rudra Pratap Singh](https://github.com/rudrapratapsingh2000)

* LinkedIn: [Rudra Pratap Singh](https://www.linkedin.com/in/rudra-pratap)
    
---

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page]("url").
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
    
## 📝 License

Copyright © 2023 [Rudra Pratap Singh](https://github.com/rudrapratapsingh2000).<br />

This project is [MIT]("url") licensed.
