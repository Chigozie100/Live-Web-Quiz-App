# 9IJAKIDS ASSESSMENT
API for a live Web Quiz Application 

## **PREREQUISITES**
1. mySqlWorkBench must be running locally
2. Request and response objects are stored in mySql database, based on the configured properties.

# Technologies
* Java 
* Maven 
* Spring Boot 
* JUnit
* mySql

# Requirements
You need the following to build and run the application:

* JDK 17
* Maven 3.8.1 (Optional as code already contains maven wrapper)

# How to run
step 1 - clone project with from [here](https://github.com/Chigozie100/Live-Web-Quiz-App)

**git clone git@github.com:Chigozie100/Live-Web-Quiz-App.git**

step 2 - move into the project directory
 cd live-web-quiz-app/

step 3 - Generate the .jar file
 mvn clean install
 OR
 ./mvnw clean install

step 4 - run the project
 java -jar live-web-quiz-app.jar

# Testing the API endpoints with various inputs 
## EndPoints 

1. Join Quiz
`   localhost:8080/api/user/joinQuiz
`
_Request_
   {
   "code": "98",
   "email":"ada@gmail.com",
   "score": 80.0,
   "round": 1
   }

_Response_
{
"message": "Successfull",
"success": true,
"payload": {
"id": 3,
"code": "98",
"email": "ada@gmail.com",
"score": 80.0,
"round": 1
}
}
![](../../Desktop/Screenshot 2023-01-01 at 14.46.41.png)

2. Submit Answer
   `localhost:8080/api/answer/submitAnswer/3`
_Request_
   {
   "questionId":"2",
   "answer": "for football"
   }
_Response_
   {
   "message": "Successfull",
   "success": true,
   "payload": {
   "id": 3,
   "questionId": 2,
   "answer": "for football",
   "user": {
   "id": 3,
   "code": "98",
   "email": "ada@gmail.com",
   "score": 80.0,
   "round": 1
   }
   }
   }
![](../../Desktop/Screenshot 2023-01-01 at 14.54.23.png)

3. getAllUsersParticipating
   `localhost:8080/api/user/getAllUsersParticipating`
 _Get Request_
   {
   "message": "Successfull",
   "success": true,
   "payload": [
   {
   "score": 45.5,
   "round": 1
   }
   ]
   }
![](../../Desktop/Screenshot 2023-01-01 at 15.00.21.png)

4. Update Round
   `localhost:8080/api/user/updateRound/1`
_Request_
   {
   "round":3
   }
_Response_
   {
   "message": "Successfull",
   "success": true,
   "payload": {
   "score": 45.5,
   "round": 3
   }
   }
![](../../Desktop/Screenshot 2023-01-01 at 15.04.13.png)

5. Get Result of Users
   `localhost:8080/api/user/getUsersByScore`
_Get Request_
   {
   "message": "Successfull",
   "success": true,
   "payload": [
   {
   "id": 3,
   "code": "98",
   "email": "ada@gmail.com",
   "score": 80.0,
   "round": 1
   },
   {
   "id": 1,
   "code": "1",
   "email": "gozie@gmail.com",
   "score": 45.5,
   "round": 3
   },
   {
   "id": 2,
   "code": "23",
   "email": "prince@gmail.com",
   "score": 20.0,
   "round": 1
   }
   ]
   }
![](../../Desktop/Screenshot 2023-01-01 at 15.07.29.png)








