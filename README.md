# mittpp-project
This repository contains coursework for the course Methods and Techniques for Software Testing. It includes various testing methodologies, practical assignments, and implementations of different testing techniques to ensure software reliability and quality.

## Overview 📝

This project implements an **automation testing framework** for a web application using:
- **Selenium WebDriver** for interacting with web elements
- **JUnit 4** for writing and running tests
- **Maven** for build, dependency management, and report generation

It demonstrates various testing techniques including:
- **Page Object Model (POM)**
- **Explicit waits**
- **Cross-browser testing** (support for Chrome and Firefox)
- **Aggregated HTML test report generation**

The framework tests several functionalities on [The Internet](http://the-internet.herokuapp.com/), including:
- Home Page Load Test 🏠
- Form Authentication (Valid and Invalid Login) 🔐
- Add/Remove Elements ➕➖
- Checkboxes ☑️
- Context Menu 🍔
- Multiple Windows 🪟
- File Download 📥
- Entry Ad 📢
- Infinite Scroll 🔄

---

## Technologies and Tools ⚙️

- **OS:** macOS (Sequoia 15.0.1)
- **Language:** Java (v23)
- **Testing Framework:** JUnit (v4.13.2)
- **Automation Tool:** Selenium WebDriver (v4.8.0)
- **Driver Management:** local drivers (ChromeDriver, GeckoDriver) - Use versions that match your browser version
- **Build Tool:** Maven (v4.0.0)
- **Reporting:** Maven Surefire & Surefire Report plugins (v2.22.2)

---

## Project Structure 📂
```bash
mittpp-project/
├── pom.xml
├── README.md
├── runTests.sh         // Bash script to run tests with interactive browser selection
└── src
    ├── main
    │   └── java
    └── test
        └── java
            ├── pages        // Page Object classes: HomePage, FormAuthPage, etc.
            └── tests        // Test classes: HomePageTest, FormAuthenticationTest, etc.
            └── utils        // Help classes, npr. DriverFactory, WaitUtils
```

---

## Installation instructions:

### Prerequirements:

- **Drivers:**  
  - If you use local drivers, ensure that ChromeDriver and GeckoDriver are placed in the appropriate directory (eg `~/Desktop/Development/drivers`) and configured in `DriverFactory.java`.
- **IntelliJ IDEA:**
  - https://www.jetbrains.com/idea/download/?section=mac
- **node.js & npm:**
  - https://nodejs.org/en/download/

### Cloning the repository

Clone the repository and change to the project directory:

```bash
git clone <URL_repository>
cd mittpp-project
```

## Running the tests

The project contains a bash script runTests.sh that:

Will prompt for browser selection.
Run tests with the selected browser.
Generate an aggregated HTML report.  ( target/site/surefire-report.html )

To run the script:
```bash
cd "where you cloned the repository"
bash runTests.sh
```

## Troubleshooting

1. Apple could not verify “chromedriver” is free of malware that may harm your Mac or compromise your privacy

   1.1. Go to: System Settings -> Privacy & Security

   1.2. Scroll down to Security section
   
   1.3. You should see a message like: "chromedriver was blocked because it is not from an identified developer."
   
   1.4. Click Allow Anyway
   
   1.5. Now, try running the chromedriver again

2. File Download test fail

   2.1. Go to the site where the file is being downloaded from
   2.2. Check if the file is still there
   2.3. If not, choose another file
   2.4. Change all the "img.png" appearances to the "newfile.extension" in the FileDownloadPage and FileDownloadTest

## Contact

If you have any questions feel free to reach out to me.
email: jurajdurcevic11@gmail.com


