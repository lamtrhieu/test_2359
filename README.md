# test_2359
How to run 
- I use springboot and maven. So the application can be run with cmd "mvn spring-boot:run". Works on both Windows and Linux
- The application is a traditional 3 tier application. Controller, Service and Repository. 
- For simplicity I just use in-memory for repository layer. Mapping directly to a DBMS should be too time consuming for this test.
- A postman json collection is provided so that you can start up application and use postman to made rest api call

Test cases:

User: 
- User singup
- User login
- User get all shape categories 
- User select a shape categories and submit shape
- User saved shapes 
- User get all saved shapes 

Admin: 
- Login as seeded admin
- Use seeded admin to create another admin
- Use seeded admin to delete admin
- Admin can submit custom shape category 


Known Limitation:
- For security feature. I use Spring Oauth2 as the client is mobile/tablet client so Oauth is the way to go. 
But I just use Oauth2 to authorize and use another endpoint to get user information as a hack for authentication. For authentication, I should better
use OpenID connect and JWT token for that purpose. But again, I am running out of time for that.  
- Should have provide more integration tests for controller classes.
- I haven't implemented the feature for admin to crud shape for kid. But with the current model and architecture.
It should be straight-forward. 
- I haven't implemented the requirement to allow submit category with area formula and conditions. 
But I have document the approach I would use in the code. I think I would  use an expression evaluator to calculate the 
area based on the formula and the shape attributes. Same for conditions, I would also use expression evaluator to evaluate
and for each conditions evaluate to true, I would add the corresponding shape categories into the shape.
- The data access code in UserServiceImpl should be refactor into UserRepository. 

Feedback: 
- The test is challenging and time-consuming. I personally think that the test should be designed to test the candidate ability
to showcase his OOP or functional language skills. Not to implements a full application like this one.
- 
