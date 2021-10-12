# Virgin Atlantic - Flight Information Display app

App name - virgin-atlantic-assessment

App type - Spring Boot Microservice

## Requirements

For building and running the application you need:

JDK 1.8 or higher

STS/ Eclipse (or any IDE)

## Running the application locally

Download the flight information project by using Download Zip option under Code dropdown. It should be download as virgin-atlantic-assessment-master.zip.

Now there are two options to run the application locally.
1. Execute the executable boot jar in virgin-atlantic-assessment\jar folder. It contains all the necessary dependencies, classes, and resources and run it.  
    a) Open the console/ command window and go to virgin-atlantic-assessment\jar
  
    b) Execute the jar by running following command in the console
    java -jar virgin-atlantic-assessment-0.0.1-SNAPSHOT-boot.jar

2. Setup the project in your workspace and run it run locally by following steps below:
   
    a) Import virgin-atlantic-assessment-master/virgin-atlantic-assessment/ project into workspace.
  
    b) Refresh Gradle in case it was not refreshed properly after importing project
  
    c) Application should have automatically built if Build Automatically option is enabled otherwise use Eclipse's Build Project option to build the project.
  
    d) Run the main method in the com.va.assessment.kundan.VirginAtlanticAssessmentApplication class from your IDE to start the application. Use Run as Spring Boot Application option.

  
## Test the application

Since application is now up and running so you may now test the application functionlities.

Open a browser and visit http://localhost:8080/searchflights. Enter any valid date in MM/DD/YY format and press Search Flights button. It will search for all the
flights on that day and display the flights in the chronological order in next page. If you want to search flights on different date then click on Go Back button,
it will take you to the previous search flight screen.

This application also has a REST API to search flights on a day. Format of the endpoint is:

http://localhost:8080/flights/{Date_in_YYYY-MM-YY_format}  

Example url - http://localhost:8080/flights/2021-10-13

