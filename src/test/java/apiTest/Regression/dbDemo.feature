Feature: Call java demo

  Background:

   # Create JDBC connection with DbUtils java class
    * def config = { username: "root", password: "deepak", url: "jdbc:mysql://127.0.0.1:3306/sakila?characterEncoding=utf8", driverClassName: "com.mysql.cj.jdbc.Driver" }
    * def DbUtils = Java.type("apiTest.DbUtils")
    * def db = new DbUtils(config)

  Scenario: Get a particular actor detail from mysql default saqila table

    * def actorMatchingLastNames = db.readRows("SELECT last_name FROM sakila.actor where first_name = 'PENELOPE' ")
    And print actorMatchingLastNames
   * def actorDetailFullRowAsList = db.readRow("SELECT * FROM sakila.actor where first_name = 'NICK' and last_name = 'STALLONE'")
    And print actorDetailFullRowAsList
    * def actorNameValueCheck =  db.readValue("SELECT last_name FROM sakila.actor where first_name = 'PENELOPE' and actor_id =1")
     And print actorNameValueCheck
