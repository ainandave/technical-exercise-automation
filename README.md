# QA Automation Technical Exercise

## Overview

This project automates the purchase of a 7-day SIM plan on the amaysim website and verifies that a declined credit card payment displays the correct error message.

The scenario was implemented using a clean Page Object Model (POM) design with Cucumber (BDD) and Selenium WebDriver.

---

## Dependencies

- Java 17+
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- WebDriverManager

---

## Project Structure

- **pages/** → Page Object Model implementation  
- **stepdefinitions/** → Business scenario mapping  
- **utils/** → DriverFactory, ConfigReader, TestData  
- **hooks/** → Setup and teardown logic  
- **features/** → Gherkin feature file  

---

### Configuration
- Configuration is handled via:
 src/test/resources/config.properties

You can configure:
- `browser`
- `headless`
- `env`
- `prod.url`

To toggle headless mode:

headless=true

or

headless=false

---

## How To Run The Tests

### Run via Maven (Recommended)
```bash
mvn clean test

### Run via GUI (IntelliJ)
- Open TestRunner.java
- Right-click → Run


### Author

* Ainan Dave Dominguez
