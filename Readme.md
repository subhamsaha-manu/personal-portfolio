A Spring Boot applicaiton to act as a backend for My Website. The front end is also a git project available at the following location :-

https://github.com/subhamsaha-manu/personal-porfolioUI.

Kindly, go through the Readme.md file to understand how to deploy or view the app.

As mentioned this project is a backend written in Spring Boot. Few salient features are :-

# Salient Features :-

1. Proper project structure with models, repository,services and dtos.
2. The Models are structured in accordance with the MongoDB collection object.
3. DTOs have been written as replicas of the Model classes which interact between the UI(Application) and Service Layer, whereas the Models interact between the Service and Database layer.
4. To seamlessly map between the Model and DTO I have used MapStruct api's, and also introduced some custom mapping rules.
5. Lombok has been used to generate Getter Setters and Constructors where ever required for the various classes, which reduce the amount of boilerplate code to be written.
6. Spring Data has been used to connect with the Mongo database setup in mLab service of Heroku.
7. Spring Email has been used to send email notification when any user wants to connect via the Contact Me form in the UI app.
8. Application wide logging has also been introduced with the help of Lombok and relevant annotations.
9. The individual app is hosted in Heroku in the following location :-
https://dashboard.heroku.com/apps/my-personal-porfolio-app
10. And the overall UI app is also hosted via Heroku and is accessible at :-
https://subham-sportfolio.herokuapp.com/
11. The master branch of this project also acts as a template for future Spring Boot apps.

For any queries or issues feel free to contact at :- subhamsaha90@gmail.com
