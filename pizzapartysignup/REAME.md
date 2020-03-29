# Pizza Party Sign Up

> This application accepts Contact information and allows a privileged user to send an SMS notification to all Contacts.

## Prerequisites to run
- Java 8
- Maven
- MySQL database (tested on v8.0.19)
	- schema db_example
	- granted user "springuser" with password "ThePassword"
- The associated authToken provided, to launch with command:
	- mvn spring-boot:run -Dspring-boot.run.arguments=--authToken=<<PROVIDED_TOKEN_VALUE>>
	
## Technologies Used
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA
- Thymeleaf
- Twilio SDK
	