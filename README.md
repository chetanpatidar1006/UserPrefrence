# UserPrefrence

User Preference Microservice
This microservice is part of a larger application that aggregates users' social media profiles. It manages user preferences for dark/light modes and selected social media platforms.

Features
Manage user preferences for dark/light mode.
Select preferred social media platforms.
Use an in-memory H2 database for development and testing.
API documentation via Swagger UI.
Architecture
The application follows a microservices architecture with the following services:

User Service - Manages user registration and profiles.
Influencer Service - Manages influencer profiles and their associations with users.
Feed Service - Aggregates and provides feeds from various social media platforms.
User Preference Service - Manages user preferences such as dark/light mode and social media platforms.
Getting Started


Prerequisites
Java 17 or higher
Maven for building the project


Clone the Repository

git clone https://github.com/chetanpatidar1006/UserPrefrence
cd your-repository

Build the Project Using Maven:
mvn clean install


Application Configuration

The microservice uses an in-memory H2 database for development and testing. Configuration is set in src/main/resources/application.properties.

Running the Application
Run the application using the command:

mvn spring-boot:run

Accessing Swagger UI
Once the application is running, you can access the Swagger UI for API documentation at:

http://localhost:8080/swagger-ui.html

API Endpoints
Get User Preferences
Endpoint: GET /api/preferences/{userId}
Description: Retrieve the preferences for a specific user.

Response:
{
  "id": 1,
  "darkMode": true,
  "platforms": ["Facebook", "Instagram", "Twitter"]
}
Update User Preferences
Endpoint: POST /api/preferences/{userId}

Description: Update the preferences for a specific user.

Request Body:
{
  "darkMode": true,
  "platforms": ["Facebook", "Instagram", "Twitter"]
}


Response:

{
  "id": 1,
  "darkMode": true,
  "platforms": ["Facebook", "Instagram", "Twitter"]
}


Running Tests
Using Maven:
mvn test
Using Gradle:

./gradlew test
Project Structure
src/main/java/com/userpreference/model/ - Contains JPA entity models.
src/main/java/com/userpreference/repository/ - Contains repository interfaces.
src/main/java/com/userpreference/service/ - Contains service layer classes.
src/main/java/com/userpreference/controller/ - Contains REST controller classes.
src/test/java/com/userpreference/ - Contains unit tests for the service layer.
API Documentation
API documentation is generated automatically and can be accessed via Swagger UI. It provides interactive API documentation to explore and test endpoints.

Troubleshooting
H2 Console: You can access the H2 console for debugging at http://localhost:8080/h2-console.
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password
Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.
