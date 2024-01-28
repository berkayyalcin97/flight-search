You can find the case study demonstration video in the following link : 
https://youtu.be/lT3wqbbEi7Y


In this case study, I used microservice architecture and developed a simple flight and airport services. In this case, I used current technologies such as Api Gateway - Discovery Client and Flyway for database migration and Swagger for Api documentation.

CRUD operations are performed in both of my services. I also used Spring Security in my flight service to ensure that only the administrator can access the service. I also created mock data in Scheduled Job and added airports named "Amadeus Airport" and "Mock Airport" to the database every 3 minutes.

As it can be seen in the video, if admin and password are entered incorrectly, the page does not open. In addition, as seen in the following parts of the video, Scheduled backgroud Job is automatically triggered by itself and mock records go to the database.
