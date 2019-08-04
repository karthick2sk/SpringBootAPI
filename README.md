# Spring Boot Application Template/Starter-Project


### Requirements

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation).

### Git Repository Link
Below is th Git repository link:
~~~
https://github.com/karthick2sk/SpringBootAPI.git
~~~

### Database

It uses a H2 in memory database (for now), can be changed in the `application.properties` for any other database.


### Running the application locally

There are several ways to run a Spring Boot application on your local machine. 
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.
### Packages

- `models` — to hold our entities;
- `repositories` — to communicate with the database;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;
- `bootstrap` — to load initial add to customer table in DB;
- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

### Explore Rest APIs

The app defines following CRUD APIs.

    POST /count
    
    POST /customer
    
    GET /findCustomer?id=(parameter)
    
    GET /findAllCustomer
    


You can test them using postman or any other rest client.


### POST  /count

Using Postman set the request type to POST and input URL as 

~~~
localhost:8080/count
~~~

In the request body select the raw JSON as input data type. Sample Input format as follows

~~~
{
	"para" : "this is a string string test test apple ball apple"
	
}
~~~

Once you send the request the Output will look like:

~~~
[
    {
        "w": "a",
        "n": 1
    },
    {
        "w": "apple",
        "n": 2
    },
    {
        "w": "ball",
        "n": 1
    },
    {
        "w": "is",
        "n": 1
    },
    {
        "w": "string",
        "n": 2
    },
    {
        "w": "test",
        "n": 2
    },
    {
        "w": "this",
        "n": 1
    }
]
~~~

### POST  /customer

This Rest call will insert the data into customer and address table. It will insert customer id as foreign key into address table. 

Using Postman set the request type to POST and input URL as 

~~~
localhost:8080/customer
~~~

In the request body select the raw JSON as input data type. Sample Input format as follows

~~~
{
	"fst_nm" : "Karthick" ,
	"last_nm" : "Tst",
	"gender" : "male",
	"dob" : "01 JAN 1990",
	"phone" : "1234567890",
	"addresses" : [{"addr_ln1" : "123 main st", "addr_ln2": "a4","city":"okemos","state":"michigan","zip":"48864" }]
}
~~~
once you send the request out will be as follows.
~~~
customer has been added.
~~~

### GET /findCustomer?id=(parameter)

This Rest call will get customer values from customer table and address table based on customer ID.

Using Postman set the request type to GET and input URL as 

~~~
localhost:8080/findCustomer?id=3
~~~

Once you send the request sample will be as follows:

~~~
{
    "id": 3,
    "fst_nm": "Karthick",
    "last_nm": "Tst",
    "dob": "01 JAN 1990",
    "gender": "male",
    "phone": "1234567890",
    "addresses": [
        {
            "id": 1,
            "addr_ln1": "123 main st",
            "addr_ln2": "a4",
            "city": "okemos",
            "state": "michigan",
            "zip": 48864
        }
    ]
}
~~~

### GET /findAllCustomer

This Rest call will get customer values from customer table and address table based on customer ID.

Using Postman set the request type to GET and input URL as 

~~~
localhost:8080/findAllCustomer
~~~

Once you send the request sample will be as follows:

~~~
[
    {
        "id": 1,
        "fst_nm": "John",
        "last_nm": "Snow",
        "dob": "01 Jan 1950",
        "gender": "Male",
        "phone": "1234567890",
        "addresses": []
    },
    {
        "id": 2,
        "fst_nm": "Arya",
        "last_nm": "Stark",
        "dob": "01 Jan 1970",
        "gender": "Female",
        "phone": "9876543210",
        "addresses": []
    },
    {
        "id": 3,
        "fst_nm": "Karthick",
        "last_nm": "Tst",
        "dob": "01 JAN 1990",
        "gender": "male",
        "phone": "1234567890",
        "addresses": [
            {
                "id": 1,
                "addr_ln1": "123 main st",
                "addr_ln2": "a4",
                "city": "okemos",
                "state": "michigan",
                "zip": 48864
            }
        ]
    }
]
~~~
### Database Structure


Customer table with sample data.
~~~
ID  	DOB  	    FST_NM  	GENDER  	LAST_NM  	PHONE  
1	01 Jan 1950    	John	    Male	    Snow	    1234567890
2	01 Jan 1970	    Arya	    Female	    Stark	    9876543210
3	01 JAN 1990	    Karthick	male	    Tst	        1234567890
~~~

Address table with sample data.
~~~
ID  	ADDR_LN1  	    ADDR_LN2  	CITY  	STATE  	    ZIP  	CUSTOMER_ID  
1	    123 main st	    a4	        okemos	michigan	48864	3
~~~

### Logging

Log file(app.log) can be found in the project folder.


### JaCoCo Report
For code coverage report to be generated we can run the below command in CLI with the pom.xml directory path

~~~
mvn test
~~~

You can find the recent report in the below link:

~~~
https://github.com/karthick2sk/SpringBootAPI/blob/master/target/site/jacoco/index.html
~~~

To run the JaCoco Report alone in maven run th ebelow command in CLI with the pom.xml directory path

~~~
mvn jacoco:report
~~~
