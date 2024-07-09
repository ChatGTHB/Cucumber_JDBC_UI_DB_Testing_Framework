### README for Cucumber JDBC UI DB Testing Framework

---

## Overview

The Cucumber JDBC UI DB Testing Framework is an automated testing solution designed for seamless integration of UI and database (DB) testing using Cucumber, Selenium, JDBC, and TestNG. This framework supports cross-browser testing and generates detailed reports.

---

## Features

- **Scenario Outline**: Utilize Gherkin syntax for defining test scenarios.
- **Data Table**: Incorporate data tables for parameterized testing.
- **Runner Class**: Execute tests using the TestNG runner class.
- **Reports**: Generate detailed test reports.
- **Cross Browsers**: Support for multiple browsers.
- **Apache POI**: Read and write data to Excel files.
- **JDBC**: Perform database operations using JDBC.

---

## Installation

1. **Clone the repository**:
    - Open IntelliJ IDEA.
    - Go to `File` > `New` > `Project from Version Control`.
    - In the URL field, enter the repository URL: `https://github.com/ChatGTHB/Cucumber_JDBC_UI_DB_Testing_Framework.git`.
    - Click `Clone`.

2. **Open the project**:
    - IntelliJ IDEA will automatically detect and import the project as a Maven project.
    - Wait for the dependencies to be downloaded.

---

## Configuration

1. **Configure properties**:
    - Open `src/test/resources/cucumber.properties` and `src/test/resources/extent.properties`.
    - Update the files with your database and browser details.

---

## Usage

1. **Run tests**:
    - In IntelliJ IDEA, open the `src/test/java` directory.
    - Right-click on any test file or directory and select `Run 'TestName'`.

---

## Folder Structure

```
Cucumber_JDBC_UI_DB_Testing_Framework/
│
├── .idea/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── apachePOI/
│       │   ├── featureFiles/
│       │   ├── jdbc/
│       │   ├── pages/
│       │   ├── runners/
│       │   ├── stepDefinitions/
│       │   ├── utilities/
│       │   └── xml/
│       └── resources/
│           ├── cucumber.properties
│           └── extent.properties
│
├── target/
├── test-output/
├── testReports/
├── .gitignore
├── pom.xml
└── README.md
```

---

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or issues, please open an issue in this repository.

---

This README provides a comprehensive guide to setting up and using the Cucumber JDBC UI DB Testing Framework, ensuring efficient and effective automated testing.

For more details, visit the [GitHub repository](https://github.com/ChatGTHB/Cucumber_JDBC_UI_DB_Testing_Framework).