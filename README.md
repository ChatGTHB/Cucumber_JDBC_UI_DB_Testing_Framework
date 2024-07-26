
# Cucumber JDBC UI DB Testing Framework

![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7300?style=for-the-badge&logo=testng&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-00758F?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-231F20?style=for-the-badge&logo=apache&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## Introduction

The Cucumber JDBC UI DB Testing Framework is an automated testing solution designed for seamless integration of UI and database (DB) testing using Cucumber, Selenium, JDBC, and TestNG. This framework supports cross-browser testing and generates detailed reports.

### Why Use This Framework?

In modern software development, ensuring the quality of both the user interface and the backend database is crucial. Manual testing can be time-consuming and prone to errors. This framework offers a robust solution by combining the strengths of Cucumber for behavior-driven development (BDD), Selenium for UI testing, JDBC for database interactions, and TestNG for test execution and reporting.

### Key Benefits

- **Seamless Integration**: Easily integrate UI and DB tests in a single framework.
- **Behavior-Driven Development**: Use Gherkin syntax to define test scenarios in a human-readable format.
- **Cross-Browser Support**: Test your application across multiple browsers to ensure compatibility.
- **Detailed Reporting**: Generate comprehensive test reports to quickly identify and fix issues. Reports are produced in both HTML and PDF formats and may include screenshots.
- **Parameterized Testing**: Use data tables for running tests with multiple sets of data.
- **Easy Configuration**: Simple configuration for different environments and databases.
- **Apache POI Integration**: Read and write Excel files using Apache POI.
- **Jenkins Integration**: The framework can be easily integrated into Jenkins for continuous integration/delivery (CI/CD) processes.
- **Page Object Model (POM)**: Improve test maintenance and readability by using the Page Object Model design pattern.

### Application Under Test

This framework is currently used to test the [Mersys](https://test.mersys.io/) application. Mersys is a comprehensive solution that requires thorough testing to ensure its reliability and performance.

### Database Used

This framework uses the [Sakila](https://dev.mysql.com/doc/sakila/en/) database for database testing. Sakila is an example database commonly used for educational and testing purposes.

### Reporting

Test results are stored in the `test-output` and `testReports` directories. Test reports are generated in both HTML and PDF formats and may include screenshots. Additionally, test scenario results are recorded in the `ScenarioResults.xlsx` file.

The `ScenarioResults.xlsx` file provides a mini-report for each test scenario, including the scenario name, status (passed/failed), and the browser used. This is done using the `Hooks` class in the framework.

Example `ScenarioResults.xlsx` content:

| Scenario Name     | Status   | Browser   |
|-------------------|----------|-----------|
| Login Test        | Passed   | Chrome    |
| Search Test       | Failed   | Firefox   |
| Checkout Test     | Passed   | Edge      |

## Table of Contents

1. [Features](#features)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Usage](#usage)
5. [Parallel Testing](#parallel-testing)
6. [Folder Structure](#folder-structure)
7. [Dependencies](#dependencies)
8. [Contributing](#contributing)
9. [License](#license)
10. [Contact](#contact)

## Features

- **Scenario Outline**: Define test scenarios using Gherkin syntax for behavior-driven development (BDD).
- **Data Table**: Use data tables for parameterized testing with multiple data sets.
- **Runner Class**: Execute tests using the TestNG runner class.
- **Reports**: Generate detailed test reports in HTML and PDF formats, including screenshots.
- **Cross-Browser Support**: Ensure compatibility by testing your application across multiple browsers.
- **Apache POI**: Read and write Excel files for test data management.
- **JDBC**: Perform database operations using JDBC.
- **Jenkins Integration**: Easily integrate with Jenkins for continuous integration and delivery (CI/CD) processes.
- **Page Object Model (POM)**: Improve test maintenance and readability by using the Page Object Model design pattern.

## Installation

1. **Clone the repository**:
    - Open IntelliJ IDEA.
    - Go to `File` > `New` > `Project from Version Control`.
    - In the URL field, enter the repository URL: `https://github.com/ChatGTHB/Cucumber_JDBC_UI_DB_Testing_Framework.git`.
    - Click `Clone`.

2. **Open the project**:
    - IntelliJ IDEA will automatically detect and import the project as a Maven project.
    - Wait for the dependencies to be downloaded.

## Configuration

1. **Configure properties**:
    - Open `src/test/resources/cucumber.properties` and update the file with your database and browser details:
        ```properties
        browser=chrome
        dbUrl=jdbc:mysql://localhost:3306/sakila
        dbUser=root
        dbPassword=password
        ```
    - Open `src/test/resources/extent.properties` and configure reporting options:
        ```properties
        reportPath=test-output/extent-report.html
        screenshotPath=test-output/screenshots/
        ```

## Usage

1. **Run tests**:
    - In IntelliJ IDEA, open the `src/test/java` directory.
    - Right-click on any test file or directory and select `Run 'TestName'`.

2. **Jenkins Integration**:
    - Create or configure a Jenkins job.
    - Add a `Build Step` to run tests using the `pom.xml` file. Follow these steps:

      a. **Add a Maven Project in Jenkins**:
      - In Jenkins, click "New Item".
      - Enter a project name and select "Maven Project".
      - Click "OK".

      b. **Source Code Management**:
      - In the "Source Code Management" section, enter the Git repository URL.
      - Provide necessary credentials.

      c. **Build Triggers**:
      - In the "Build Triggers" section, select appropriate triggers (e.g., "GitHub hook trigger for GITScm polling").

      d. **Build Steps**:
      - In the "Build" section, click "Add build step" and select "Invoke top-level Maven targets".
      - In the "Goals" field, enter `clean test`.

      e. **Post-build Actions**:
      - In the "Post-build Actions" section, add "Publish HTML reports" and specify the path to the HTML reports (e.g., `test-output`).

## Parallel Testing

To run tests in parallel using TestNG XML files, you can use the provided `ParallelTest.xml`, `RegressionTest.xml`, and `SmokeTest.xml` files. Follow these steps to enable parallel execution:

1. **Use the `ParallelTest.xml` file**:
    - Open the `ParallelTest.xml` file located in the `src/test/resources/xml` directory.
    - Ensure the suite tag includes `parallel` and `thread-count` attributes. For example:
      ```xml
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
      <suite name="ParallelSuite" parallel="tests" thread-count="4">
          <test name="ParallelTest1">
              <classes>
                  <class name="com.example.tests.TestClass1"/>
              </classes>
          </test>
          <test name="ParallelTest2">
              <classes>
                  <class name="com.example.tests.TestClass2"/>
              </classes>
          </test>
      </suite>
      ```

2. **Run the tests**:
    - In IntelliJ IDEA, right-click on the `ParallelTest.xml` file and select `Run 'ParallelTest.xml'`.
    - This will execute the tests defined in the XML file in parallel, according to the configuration.

## Folder Structure

```
Cucumber_JDBC_UI_DB_Testing_Framework/
│
├── .idea/                      # IntelliJ IDEA configuration files
├── src/
│   ├── main/                   # Main source code
│   └── test/                   # Test source code
│       ├── java/
│       │   ├── apachePOI/      # Apache POI
│       │   ├── featureFiles/   # Gherkin feature files
│       │   ├── jdbc/           # JDBC related files
│       │   ├── pages/          # Page Object Model files
│       │   ├── runners/        # TestNG runner classes
│       │   ├── stepDefinitions/# Cucumber step definitions
│       │   ├── utilities/      # Utility classes and helpers
│       │   └── xml/            # XML configuration files
│       └── resources/
│           ├── cucumber.properties  # Cucumber configuration files
│           └── extent.properties    # Extent reporting configuration files
│
├── target/                     # Maven build output
├── test-output/                # TestNG and Extent reports
├── testReports/                # Custom test reports
├── .gitignore                  # Git ignore file
├── LICENSE                     # License file
├── pom.xml                     # Maven configuration file
└── README.md                   # Project README file
```

## Dependencies

The following dependencies are required for the project to work. These dependencies are added in the `pom.xml` file:

- **Selenium**: Used for UI test automation.
- **Cucumber**: Used for behavior-driven development (BDD).
- **TestNG**: Used for organizing and running tests.
- **Cucumber TestNG**: Integrates Cucumber with TestNG.
- **SLF4J API**: Logging framework.
- **SLF4J Simple**: Simple logging implementation for SLF4J.
- **Apache Commons Lang**: Utility library for Java.
- **Extent Reports Cucumber Adapter**: Integrates Extent Reports with Cucumber.
- **Apache POI**: Library for reading and writing Excel files.
- **Apache POI OOXML**: Extension for handling Office Open XML (OOXML) files.
- **MySQL Connector**: JDBC driver for MySQL.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For questions or issues, please open an issue in this repository.

---
