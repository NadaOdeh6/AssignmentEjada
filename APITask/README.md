# AutomationProject
Overview

This project is a test automation framework that automates the testing of a web application, an Android mobile app, and an API. It uses Java and several automation tools like Selenium, Cucumber, Appium, and REST Assured to cover different types of testing.

What’s Included
UI Tests (Web):

Automates test scenarios on the website https://www.saucedemo.com/ using Selenium and Cucumber.
Supports Chrome and Firefox browsers.
Uses a configuration file to control the browser and URL.
Tests can run in parallel for faster execution.
Follows the Page Object Model (POM) design pattern.
Automates a data-driven test that runs with multiple sets of data.
Mobile Tests (Android):

Automates login scenarios (positive and negative) for the provided Android app.
Uses Appium to interact with the mobile application.
API Tests:

Automates basic API requests like GET, POST, PATCH, and DELETE using REST Assured.
Covers standard CRUD operations.
Prerequisites
Before running the tests, make sure you have the following installed:

Java (JDK 8+)
Maven
ChromeDriver (for Chrome) and GeckoDriver (for Firefox)
Appium and Android Studio (for mobile testing)
Git
Tools and Technologies
Java: Programming language used for writing the tests.
Selenium WebDriver: Browser automation tool.
Cucumber: Used to write test cases in plain English (Gherkin language).
Junit: Manages test execution.
REST Assured: For API testing.
Appium: For mobile app automation.
Extent Reports: Generates detailed test execution reports.
