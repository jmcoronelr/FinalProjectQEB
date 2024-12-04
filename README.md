# Quality Engineering Automated Testing for ParaBank

## Overview
This project is a **Quality Engineering Automated Testing Framework** for testing critical functionalities of the ParaBank online banking application. The framework ensures high-quality standards for features like user registration, account management, fund transfers, and transaction validations.

## Features
1. **Automated UI Tests**: 
   - User registration and login flows.
   - Creation and management of accounts.
   - Fund transfer validations and balance checks.
   
2. **Scalable and Modular Design**:
   - Reusable page objects for maintainability and scalability.
   - Base test setup with pre-conditions for each test suite.

3. **Performance Validation**:
   - Ensures response time for critical actions (e.g., transactions) is within acceptable thresholds.

4. **Functional Coverage**:
   - Tests cover end-to-end scenarios like creating accounts, transferring funds, and validating account details.

## Technologies Used
- **Java**: Core language for test scripting.
- **JUnit**: Framework for test execution and assertions.
- **Selenium WebDriver**: Browser automation for UI interactions.
- **Maven**: Build automation and dependency management.

---

## Project Structure
1. **Page Objects**:
   - `OpenAccountPage.java` - Handles actions related to opening new accounts.
   - `OverviewPage.java` - Manages the Accounts Overview section, including account details and navigation.
   - `RegisterPage.java` - Implements user registration functionality.
   - `TransferFundsPage.java` - Automates fund transfer processes and validation.

2. **Base Configuration**:
   - `BaseTest.java` - Provides setup and teardown methods for browser sessions and initializes test preconditions.

3. **Test Cases**:
   - `TransactionsTests.java` - Includes tests for transaction success validation, account dropdown checks, and response time verification.

---

## Key Test Scenarios
### 1. **User Registration**
   - Validate user registration with valid data.
   - Ensure proper redirection after successful registration.

### 2. **Account Creation**
   - Verify accounts can be created successfully from the "Accounts Overview" section.
   - Check the number of available accounts after creation.

### 3. **Fund Transfers**
   - Validate transfer amounts between accounts with correct balances.
   - Ensure confirmation messages are displayed within 5 seconds.
   - Verify source and destination account dropdown menus show all available accounts.

---

## How to Run the Tests
### 1. **Prerequisites**
   - Install [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) and configure the `JAVA_HOME` environment variable.
   - Install [Maven](https://maven.apache.org/) for dependency management.
   - Set up [Google Chrome](https://www.google.com/chrome/) and the [ChromeDriver](https://sites.google.com/chromium.org/driver/).

### 2. **Setup**
   - Clone the repository.
   - Run `mvn clean install` to install dependencies.

### 3. **Execution**
   - Execute tests using `mvn test`.

### 4. **Reports**
   - Test results are available in the `target/surefire-reports` directory.

---

## Contribution Guidelines
1. Write modular and reusable methods for new tests.
2. Follow naming conventions for better readability.
3. Ensure comprehensive comments for new code.
4. Run all tests locally before pushing changes.

---

## Future Enhancements
1. Integration with a CI/CD pipeline (e.g., Jenkins or GitHub Actions).
2. Extend test coverage for error scenarios and edge cases.
3. Include visual regression tests to verify UI consistency.

---

## Acknowledgments
This framework leverages Selenium WebDriver and JUnit for delivering high-quality test automation. Contributions are welcomed to expand its capabilities!
