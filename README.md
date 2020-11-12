# HargreavesTechnicalTest

## Project Title:
 Cucumber Framework for testing The Internetherokuapp website
## Introduction
This test is all about verifying the features of 3 different scenarios: 
- Form Authentication
- Dynamic Loading Feature 
- JavaScript Alerts Feature 

## Technology Used:

- An IDE
- Selenium 
- Java
- JUnit 

## Requirements
In order to utilise this project, you need to have the following installed locally:

- Maven 
- Chrome and Chromedriver 
- Java


## Framework used: Cucumber 

Feature:
This project will automate 3 features of the application 
Form Authentication
Dynamic Loading
JavaScript Alerts

## Description

The code is written in Cucumber Framework in Maven Build project
The code contains a feature files for 3 scenarios in src/test/resources
The feature file contains the steps which are written in Gherkin syntax
For the feature file there is a stepdefinition files in src/test/Java
The stepdefinion classes contains the executable steps for Given, When, Then steps
The feature file and stepdefinition files are executed from TestRunner class by adding annotations
@RunWIth(cucumber.class)
@CucumberOptions(feature:="src/rest/resources/Features", glue={"stepdefinitions"}

## Reports

The reports are saved in the Target folder and declared in TestRunner class.
Json reports:
json:target/JsonReports/report.json

Html reports:
html:target/HtmlReports/HtmlReports

Junit reports:
junit:target/JUnitReports/report.xml

## How to execute
Contextclick on the TestRunner.class and select 
Run->Junit Test

### From command Propmt

Open the command prompt and cd until the project root directory.

Cd path of project directory
>mvn test







