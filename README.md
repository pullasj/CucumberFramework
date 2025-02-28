# Cucumber Framework

This project is a Cucumber-based automation testing framework, utilizing the Page Object Model (POM) design pattern with Java, Selenium WebDriver, and Cucumber. The framework includes feature files, step definitions, page objects, utilities, and integration with Excel for data-driven testing.


### Objective of the Project:

The primary goal of this project is to provide a robust, scalable, and maintainable **automation testing framework** that supports:

- Writing automated tests in an easy-to-understand, natural language format (**BDD**).
- Automating web application interactions using **Selenium**.
- Leveraging **data-driven testing** to run tests with different sets of data for greater coverage.
- Integrating with **CI/CD pipelines** (Jenkins) to automate the testing process and ensure continuous feedback.
- Using **Docker** for consistent test environments and faster test execution across different platforms.

This framework is ideal for teams looking to implement test automation in their web applications while adopting modern practices like BDD, data-driven testing, and CI/CD. It helps improve **test coverage**, **test execution speed**, and **maintainability**, reducing the overall cost and effort of manual testing.

## Features

- **Cucumber Integration**: Utilizes Cucumber for behavior-driven development (BDD) testing.
- **Page Object Model (POM)**: Structured framework using POM to separate page elements and actions.
- **Excel Integration**: Reads data from Excel files for data-driven testing.
- **Cross-Browser Testing**: Supports multiple browsers including Chrome, Firefox, and Internet Explorer.
- **Headless Browser Support**: Option for headless browser testing (using Chrome in headless mode).
- **CI/CD Integration**: Jenkins pipeline integration for continuous integration.
- **Docker Integration**: Dockerized environment for running tests in isolated containers.

## Technologies Used

- **Java**: The programming language used for writing the test scripts.
- **Cucumber**: A tool for running automated tests written in a behavior-driven development (BDD) style.
- **Selenium WebDriver**: The framework for automating browsers.
- **Apache POI**: Library for reading and writing Excel files.
- **JUnit**: Test framework for running the tests.
- **WebDriverManager**: Handles the setup of WebDriver binaries (ChromeDriver, FirefoxDriver, etc.).
- **Docker**: For containerizing the application and running tests in isolated environments.
- **Jenkins**: Continuous integration tool for running tests automatically after every commit.

---

### Project Structure

The project is organized into several directories to separate different components:

- **`src/main/java/org/QaScript`**: Contains the main Java classes.
   - **BaseClass.java**: The base class for setting up the WebDriver and other common functionality needed by the tests.
   - **PageObjects**: Contains page objects representing various web pages (e.g., `LoginPage.java`, `HomePage.java`, etc.). These classes contain methods that interact with the web elements of the page.
   - **Utils**: Contains utility classes such as `browserUtils.java` for interacting with web elements, and `GetBrowserDriver.java` for managing different browsers.
   - **StepDefs**: Contains the step definition classes that map the steps in feature files to the corresponding Java methods.

- **`src/test/resources`**: Contains the resources for the tests.
   - **config**: Contains configuration files such as `application.properties` and `framework.properties` for setting test environment variables and configurations (e.g., base URLs, browsers).
   - **features**: Contains the `.feature` files with BDD scenarios written in Gherkin syntax.
   - **testData**: Contains Excel files (`Sample.xlsx`) for data-driven testing.

- **`pom.xml`**: The Maven configuration file that lists all dependencies and plugins required for building and running the project.
---


## Setup

1. **Clone the repository**:

```bash
git clone https://github.com/pullasj/CucumberFramework.git
```

2. **Import the project into your IDE**:
    - If using **IntelliJ IDEA** or **Eclipse**, simply import the project as a Maven project.

3. **Install Dependencies**:
    - This project uses Maven for dependency management. The required dependencies are listed in the `pom.xml` file.
    - If Maven is not installed, follow the installation instructions on the [official Maven site](https://maven.apache.org/install.html).
    - After importing the project, Maven will automatically download the necessary dependencies.

4. **Configure Test Data (Optional)**:
    - Add your test data in the `src/test/resources/testData/` folder, as the tests rely on Excel files for data-driven testing.

5. **Configure the Test Environment**:
    - Modify the `application.properties` and `framework.properties` files under `src/test/resources/config/` to set the appropriate environment URLs, browsers, and other configurations.

## Running the Tests

### **From the command line**:

Navigate to the root of the project directory and run the following Maven command:

```bash
mvn test
```

### **From your IDE**:

Right-click on the `TestRunner` class and select `Run`.

## Jenkins Integration

You can integrate this project into Jenkins for continuous integration (CI). Below are the basic steps:

1. **Install Jenkins**:
    - Follow the [official Jenkins installation guide](https://www.jenkins.io/doc/book/installing/) to set up Jenkins on your server or local machine.

2. **Create a New Pipeline Job**:
    - In Jenkins, create a new pipeline job and configure the repository URL where your project is hosted (e.g., GitHub).

3. **Configure the Pipeline**:
    - In the pipeline configuration, add the following `Jenkinsfile` to define the pipeline steps.

```groovy
pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 11'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/pullasj/CucumberFramework.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Archive Results') {
            steps {
                junit '**/target/cucumber.xml'
            }
        }
    }
}
```

This `Jenkinsfile` performs the following steps:
- **Checkout**: Clones the repository.
- **Install Dependencies**: Runs `mvn clean install` to install the necessary dependencies.
- **Run Tests**: Executes the tests with `mvn test`.
- **Archive Results**: Archives the test results.

4. **Run the Pipeline**:
    - After configuring the pipeline, trigger the job and Jenkins will automatically run the tests on each commit.

## Docker Integration

You can run the tests inside a Docker container to ensure an isolated environment. Below is the process for setting up Docker for this project:

1. **Create a Dockerfile**:
    - In the root directory of your project, create a `Dockerfile` to containerize the testing environment:

```Dockerfile
# Use an official Java runtime as a parent image
FROM maven:3.6.3-jdk-11

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the local project files into the container
COPY . .

# Run Maven to install dependencies and run the tests
RUN mvn clean install
RUN mvn test

# Command to run the tests when the container starts
CMD ["mvn", "test"]
```

2. **Build the Docker Image**:
    - Run the following command to build the Docker image:

```bash
docker build -t cucumber-framework .
```

3. **Run the Docker Container**:
    - After building the image, you can run the tests inside the container with:

```bash
docker run cucumber-framework
```

This will execute the tests in an isolated Docker container with the necessary environment already set up.

## Directory Structure

```
CucumberFramework
├── src
│   ├── main
│   └── test
│       ├── java
│       │   └── org
│       │       └── QaScript
│       │           ├── BaseClass.java
│       │           ├── PageObjects
│       │           │   ├── HomePage.java
│       │           │   ├── LoginPage.java
│       │           │   └── ProductsPage.java
│       │           ├── StepDefs
│       │           └── Utils
│       │               ├── ExcelUtils.java
│       │               ├── GetBrowserDriver.java
│       │               └── browserUtils.java
│       ├── resources
│       │   ├── config
│       │   │   ├── application.properties
│       │   │   └── framework.properties
│       │   ├── features
│       │   │   ├── ShopingCart.feature
│       │   │   └── Login.feature
│       │   └── testData
│       │       └── Sample.xlsx
└── pom.xml
```

## Contributing

Feel free to fork this repository, open an issue, or submit a pull request. Any improvements or contributions are welcome!

