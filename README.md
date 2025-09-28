![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.21.0-brightgreen)
![Cucumber](https://img.shields.io/badge/Cucumber-7.14.0--7.18.0-success)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Allure](https://img.shields.io/badge/Allure-2.27.0-yellow)
![ExtentReports](https://img.shields.io/badge/ExtentReports-5.1.1-lightblue)
![GitHub Actions](https://img.shields.io/badge/CI-GitHub%20Actions-lightgrey)
# CommerceAutomation

This is a Selenium-based automation framework for testing key user flows in the [nopCommerce demo site](https://demo.nopcommerce.com/).

![Build Status](https://github.com/Jm093/CommerceAutomation/actions/workflows/maven.yml/badge.svg)

---

## Features Automated

- User Registration
- Login / Logout
- Product Search
- Checkout Process

---

## Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Maven**
- **JUnit / TestNG**
- **GitHub Actions (CI/CD)**
- **Allure Reporting**

---

## Project Structure

```plaintext
CommerceAutomation
│── .github/
│   └── workflows/
│       └── maven.yml
│
│── .idea/
│── allure-results/
│── src/
│   ├── main/
│   │   └── java/
│   │       ├── managers/
│   │       │   └── DriverFactory.java
│   │       ├── org/example/
│   │       │   └── Main.java
│   │       ├── pages/
│   │       │   ├── CartPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   ├── ElectronicsCategory.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── RegistrationPage.java
│   │       └── utils/
│   │           ├── ConfigReader.java
│   │           ├── TestDataReader.java
│   │           ├── UserContext.java
│   │           └── WaitUtils.java
│
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── Hooks.java
│       │   ├── runners/
│       │   │   └── TestRunner.java
│       │   └── stepdefinitions/
│       │       ├── CheckoutSteps.java
│       │       ├── LoginSteps.java
│       │       ├── LogOut.java
│       │       ├── Registration.java
│       │       └── Search.java
│
│       └── resources/
│           ├── features/
│           │   ├── checkout.feature
│           │   ├── login.feature
│           │   ├── logout.feature
│           │   ├── registration.feature
│           │   └── search.feature
│           ├── config.properties
│           └── testdata.properties
│
│── pom.xml
│── README.md
│── target/
```
# Features Automated
- User Registration
- Login / Logout
- Product Search
- Add to Cart
- Checkout Process

# Tech Stack
- Java
- Selenium WebDriver
- TestNG / JUnit
- Maven
- Allure Reports
- GitHub Actions (CI/CD)
- IntelliJ IDEA

# How to Run the Tests

## 1. Clone the repository
```bash
git clone https://github.com/Jm093/CommerceAutomation/CommerceAutomation.git
cd CommerceAutomation
```
## 2. Install dependencies
```bash
mvn clean install
```
## 3. Run the tests
```bash
mvn test
```
## 4. Generate and view Allure Report
```bash
mvn clean test
allure serve allure-results
```

## CI/CD with GitHub Actions

This project uses **GitHub Actions** for continuous integration and continuous delivery.  
The workflow file is located at:  
`.github/workflows/maven.yml`

### What it does:
- ✅ Builds the project
- ✅ Executes all test scenarios
- ✅ Generates and stores test reports  

## Project Notes

⚠️ **Test Data Behavior**  
The nopCommerce demo site automatically deletes registered users after ~10 minutes of inactivity.

- To ensure reliability, each scenario includes a **fresh user registration + login** step.
- This design avoids dependency on pre-registered accounts and keeps tests independent.
- While this may appear repetitive in the scenarios, it reflects the constraints of the demo environment and ensures stable execution.

⚠️ **Browser Flags**
Certain ChromeOptions flags are included *only* to bypass anti-bot checks on the nopCommerce demo site.  
- These flags (e.g., disabling automation detection, setting a custom user-agent) are **not best practice** for production-grade test automation.  
- In a real-world company application, these would be removed to keep tests closer to actual user behavior.

🛠️ **Design Choices**
- Uses Dependency Injection (Cucumber PicoContainer) for cleaner test isolation.  
- `DriverFactory` manages browser instances with `ThreadLocal<WebDriver>` to support parallel execution.  
- Allure integrated for reporting, with screenshots captured on failure.  

🔄 **Continuous Integration**
- GitHub Actions pipeline runs tests on headless Chrome (to work in CI environments without a GUI).  
- CI currently pinned to Java 17 for library compatibility. Upgrade to Java 21 is straightforward once dependencies allow.  

🎯 **Project Purpose**
This project was created as a practice framework to showcase:
- UI automation with modern tools (Selenium, Cucumber, TestNG, Allure).  
- CI/CD integration with GitHub Actions.  
- Best practices such as Page Object Model, config management, and externalized test data.  

While the application under test is a demo site, the framework structure is production-ready and demonstrates transferable skills for enterprise projects.
