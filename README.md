# FundamentalProject1-NailApp
# **_Designer Nails App_**

### **_Resources:_**


## **_Content_**
* [Overview](#Overview)

* [Planning](#Planning)
   * [Project tracking](#Projecttracking)
   * [Risk Assessment](#RiskAssessment)

* [Testing](#Testing)
  
* [Technology](#Technology)

* [Results](#Results)

* [Improvements](#Improvements)

* [Author](#Author)

## Overview
 The objective for this project was to design a web application using the CRUD fuctionality which stands for; Create, Read, Update and Delete. The application I designed and created allows customers to book nail treatment services. The user will be able to manage their bookings by selecting a treatment.
 The user will be able to create a login to book a service, which will be stored in my Customers Database. The user can view and edit their bookings which will then be updated in the database.
 
## Planning

## Project Tracking 
For this project I intended to have three entity tables as shown below. The first diagram shows the relationship between the three entity tables, however it would have been difficult to implement the relationship between all three, so for simplicity and due to time constraint I reduced the entity tables to two.

![ERD](https://user-images.githubusercontent.com/67292767/92315028-03908a00-efd8-11ea-9741-66f749829379.png)

 Below shows the end result of the relationship between the two entity tables that was used for my web application.

![ERD](https://user-images.githubusercontent.com/67292767/92315030-07241100-efd8-11ea-93a3-aa477607ce2f.png)

A Jira board was used to create a backlog of issues which are the tasks that were assigned to create and complete my application. These tasks were divided into stories and epics which ensured that I had the suitable task assigned to the specific topic. Below are examples of tasks in different stages depending on whether the are completed or in the process of completion.

![Backlog](https://user-images.githubusercontent.com/67292767/92315039-11dea600-efd8-11ea-90c3-1b341f93b84c.png)

![Sprint Board](https://user-images.githubusercontent.com/67292767/92315020-e2c83480-efd7-11ea-9e65-cc0018f92e25.png)

## Risk Assessment
Whenever planning a project one needs to think of the potential risks that may occur. As this being my first technical project I had to think of the possible risks that may occur and how to lessen the threats of the risks; I had to assess the potential threats that can occur with the developer(Chinenye Nwandu), the user and the Cloud Service provider. Here are some of the risks and mitigations:

![Risk Assessment Table](https://user-images.githubusercontent.com/67292767/92315234-95999200-efda-11ea-9eeb-a0a210a9193d.png)

#### MoSCoW
Must have: CRUD functionality

Should have: Database 

Could have: Hyperlink buttons

Won't have: Pictures


## Testing
Testing was run on CircleCI to check whether the code is working correctly and up to date. The testing passed as seen in the image.

![CircleCI Test](https://user-images.githubusercontent.com/67292767/92315027-fffd0300-efd7-11ea-82df-0d8545b148e2.png)
![Test](https://user-images.githubusercontent.com/67292767/92337258-559ce280-f0a0-11ea-87a8-0a92a2a89335.png)


## Technology
#### CI Pipleine

![Architechure](https://user-images.githubusercontent.com/67292767/92335150-3f852700-f08c-11ea-9889-307e4b76ad98.png)

This shows the workflow of my code and the actual technology used during the progression of this project.
Javascript and HTML was used for the front-end coding for this application.

The code for my application was written in Java, to save and document my code a repository was created in Github, whereby I can retrieve my code, edit my code and commit the changes. Once I had completed a task, I would update my jira board and by updating my sprint, I was able to see what other tasks needed to be implemented. Once all of that was completed the next stage was the automated testing, building and deploying of the application. CircleCi then tests the application and if the test passes it starts to build the application depending on the tool used, for my application that would be maven. Then the application would run using the vm instance created on Goodle Cloud Platform.



## Results

The functionality within my application: Create, Read, Update & Delete .

The user is able to login and access their bookings through the booking page. Suppose the user wants to delete their booking they are able to do so with click of one button.

![Login page](https://user-images.githubusercontent.com/67292767/92315035-0db28880-efd8-11ea-89ac-218bb6ef231b.png)
![All Bookings](https://user-images.githubusercontent.com/67292767/92315023-ea87d900-efd7-11ea-9739-e19794170b8d.png)
![Update](https://user-images.githubusercontent.com/67292767/92361927-1776e180-f0e7-11ea-9860-8c62e036e7ec.png)


## Improvements
 
* My application met the MVP, however when it came to deploying the application using CircleCI it failed, it would've been better for my application to run through the cloud server rather than running it through Java. Need to fix the issue with SSH keys so that GitHub can access my username.

* Could've had a SQL server to work as the database storage for the back-end.

* My application would've been better if it had the third entity table and added the functionality for customers to edit treatments and booking.

* In the future it could be more aesthetically pleasing, but for an initial application a coloured background sufficed.
 

## Author
Chinenye Nwandu
