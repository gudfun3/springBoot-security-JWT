# Onlyvish Framework



[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](http://errorsexceptions.blogspot.com/)

This is a demo for spring boot Security with JWT

In this application the user will login to the system by providing username and password (also the captcha)
and after successful login the subsequent request will contain the jwt token as header as 
("Authorization:Bearer jlkjfldf.asjdlfjsdaf.asdjflsdjf") from which the user will be authorized to access 
the asked resources . to check whether the request contains the authorization header or not
we have implemented a JwtRequestFilter which will intercept each request to find the desired jwt token and 
then checks whether the token is valid or not after that it creates usernamePasswordAuthenticationToken
if the token is a valid one.
 

  - Basic account registration 
  - account activation via email
  - mongodb as database
  - Custom Exception Handling in Spring RestExceptionHandler

# New Features!

  - Sending Html Email template while account registration confirmation

### TechStack

This application  uses a number of open source projects to work properly:

* [Srping boot] - Best backend framework built in java
* [Mongodb ] - Mongodb NoSql database 
* [Angular 7] - Angular 7 used SPA front end


### Installation

This Application requires tomcat 8+ to run.

Install the dependencies and devDependencies and start the server.



For production environments...

### Plugins

this application is currently extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |


### Development

Want to contribute? Great!


### Todos

 - Adding more Scenario to Registration process
 - Adding Role and Authority

License
----

MIT


**Free Software, Hell Yeah!**

   [Ashutosh]: <https://ashutoshdang.github.io/>

