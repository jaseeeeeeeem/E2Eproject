Feature: Logging into the application

Scenario Outline: Positive test validation login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com" site
And Click on Login link in homepage to land on secure sign in page
When User enters <username> and <password> and logs in
Then verify that the user is successfully logged in
And close browsers

Examples:
|username			|password	|
|username1@gmail.com	|123	|
|username2@gmail.com	|223	|
|username3@gmail.com	|324523	|


