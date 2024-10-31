# API Automation Testing Project - Reqres.in Module


This project is a Java-based API automation testing suite for testing endpoints provided by the reqres.in API. It leverages RestAssured for API testing, Cucumber for behavior-driven development (BDD), and JUnit for test execution and validation.


## Project Structure
Key Components

- **build.gradle**:
    This file manages dependencies like Cucumber, RestAssured, JUnit, and others required for API testing.
- **src/test/resources/features/api.feature**:
    Contains feature files written in Gherkin syntax. These define the behavior scenarios for each API test case.
- **src/test/java/stepDef/ApiStep.java**:
Step definition file connecting Gherkin steps to Java code.
- **src/test/java/pages/ApiPage.java**:
Page class containing the core API methods used in the step definitions, including validation and request handling.
- **src/test/java/helper/Endpoint.java**:
Endpoint class defining all the URLs required for the tests.
- **src/test/java/helper/Utility.java**:
 Utility class with helper methods for test data generation, like generating random email addresses.
- **src/test/java/runner/ApiRunner.java**:
Test runner class configured to run the Cucumber tests using JUnit.
- **src/test/java/stepDef/Hooks.java**:
Hooks for setup and teardown methods that run before and after tests.


## Features and Scenarios
The api.feature file includes various scenarios to test key functionalities of the API:

- **Get a list of users**
- **Create a new user**
- **Delete a user**
- **Update a user**
- **Test invalid URLs and missing fields for negative cases**

## Prerequisites
- Java 11 or later
- IntelliJ IDEA (or any preferred IDE)
- Gradle (optional, as IntelliJ can handle Gradle tasks internally)

## Installation and Setup
1. **Clone the repository:**
   Here’s an example:
```bash
git clone <repository-url>
cd ApiAutomationReqressModule20PR18
```
2. **Open in IntelliJ IDEA:**
   - Open IntelliJ IDEA.
   - Go to File > Open, navigate to the project directory, and select the folder.
   - IntelliJ will automatically import dependencies using the build.gradle file.
3. **Build the Project (optional):**
- In IntelliJ, open the terminal and run:
```bash
gradle build
```
- This will download dependencies and compile the project.



# Running the Tests
## From IntelliJ
1. **Run a Specific Scenario:**
- Open the api.feature file.
- Right-click on the scenario you want to test and select Run 'Scenario Name'.
2. **Run All Scenarios:**
- Open ApiRunner.java in the runner package.
- Right-click and select Run 'ApiRunner'.

## From Command Line
You can also run tests directly from the command line using Gradle:
```bash
gradle apiTestReqres
```
This will execute all scenarios tagged with @api and generate an HTML report in reports/cucumber-web-report.html.

## Generating Test Reports
This project is configured to generate HTML reports after test execution. After running the tests:
- Check the reports folder for cucumber-web-report.html to view the test results.

## Customizing the Project
- Adding New Scenarios: Add new Gherkin scenarios to api.feature.
- Creating Step Definitions: Define new steps in ApiStep.java to implement actions for each scenario.
- Modifying API Endpoints: Update Endpoint.java to add or modify any endpoint URLs.

## Troubleshooting
- Dependencies: Ensure that all dependencies are loaded in the Gradle tool window. If not, try refreshing the Gradle project.
- Endpoint Issues: If you encounter any connectivity issues with the reqres.in API, check the endpoints in Endpoint.java.
