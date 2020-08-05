# Java_Selenium_Test_Automation_Demo
Test Automation project written on Java, Selenium WebDriver &amp; TestNG.
This is Parabank (fake banking website) Demo Project that includes suite of Smoke Tests.

Author: **Ildar Lutfullin**

Tools used to create the framework:
1. Java
2. Selenium WebDriver
3. TestNG framework

## Project Decription
This project uses Page Object Model. It means that test classes themselves do not contain any logic or functions implementations. Instead all logic, functions and locators are stored inside corresponding page classes. 

**This allows page methods to be reusable and test classes to be more readable.**

All we do in test classes is invoke those functions using fluent pattern:
  ```
To achieve Fluent pattern all page-related functions are not void - instead they return page class.
  ```

Each test class contains test case description with steps and test script itself.
  ```
Note: In this projects couple of implicit waits are being used - I recognize that it is not a best practice but I didn't have enough time to replace them with proper explicit waits. 
  ```

## Installation

1. Install JDK (preferably newer version, e.g. 13)
2. Install IDE (preferably IntelliJ IDEA, but Eclipse could be used as well)
3. Install Maven (version 3.5.2 or higher)
4. Install IntelliJ's Markdown plugin to properly read README.md file (IntelliJ will automatically suggest to install it).
5. Install newest version of Chrome browser.

## Usage

1. Unzip project file.
2. Open unzipped folder using IntelliJ IDEA or other IDE.
3. Execute tests one by one (you can find them here):
```
src > test > java > parabank.test
```

Thank you!
