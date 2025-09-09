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
