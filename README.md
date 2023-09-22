
# Member Detail Service

Member detail service provides a solution to manage members details. It has the ability to create members and members detail information such as phone and email. Moreover, it allow members to edit their detail information by providing API's to do so. The app will be running on **PORT 8001**.


## API Documentation

Open the following link to access the API Documentation
[API Documentation](http://localhost:8001/api/swagger-ui/index.html)


### Database Console

You can access the database console using this link
[Database Console](http://localhost:8001/api/h2-console)


### Java version

The application was build using JDK 17 with Spring Boot 3.1.3

### Running the application

To run the app, execute the following command:
```shell
mvn spring-boot:run
```
To run Junit 5 test, execute the following command:
```shell
mvn test
```

## Basic Auth Credentials

* Username: ravi
* Password: password
* Role: user

- Username: admin
- Password: password
- Role: admin

## Resource example

POST http://localhost:8001/api/members

#### Request body
```json
{
    "name": "Ravi",
    "number": "BCGEU1234",
    "emails": [
        {
            "email": "example@example.com"
        },
        {
            "email": "example@example.com"
        }
    ],
    "phones": [
        {
            "phone": "778-555-5555"
        }
    ]
}


