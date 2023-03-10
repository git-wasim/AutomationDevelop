
# Crypto Currencies Dashboard

Coinmarketcap website provides a detailed information of live market capitalizations of crypto currencies. It is the world's most-referenced price-tracking website for cryptoassets in the rapidly growing cryptocurrency space. Its mission is to make crypto discoverable and efficient globally by empowering retail users with unbiased, high quality and accurate information for drawing their own informed conclusions. 

# Automation Framework

Selenium & Java based frontend automation suite utilising the BDD methodologies of Cucumber and Gherkin 

## 1. Install JAVA SDK 8

Download java jdk 8 from the below link
https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html

## 2. Install Maven

Install maven from below link
https://maven.apache.org/download.cgi

## 3. Install Git

Install git from below link
https://git-scm.com/download/win

## 4. Install Eclipse

Install eclipse from below link
https://www.eclipse.org/downloads/

## 5. Download chromedriver 109 

Download driver from below link
https://sites.google.com/a/chromium.org/chromedriver/downloads

### Set Path Variables
User Variable Path = directory for java sdk 8 
Set Maven home in environment Variables 

### For Windows
Create the following System variables
- JAVA_HOME = PAth to java sdk
- MAVEN_HOME = Path to maven installation

### For Windows Edit Path System variable 
- Add %M2_HOME%\bin 
- Add directory to your chromedriver.exe

### Software preparatation
- mkdir AutomationDevelop
- git clone https://github.com/git-wasim/AutomationDevelop.git
- mvn clean test 

### Framework Overview
The cucumber BDD testing framework specifies acceptance tests as written from the view of the Product Owner.<br> 
Using keywords such as Given, When, Then and And, acceptance criteria tests known as feature files can then be broken down into testable steps. 

#### Cucumber Selenium 
- Overall testframework leveraging the Cucumber framework with Selenium written in JAVA.

#### Feature File 
- The feature file specifies the steps in BDD language style

#### Hooks class 
- Hooks class is most important class as it performs the following functions
- Ensures feature files trigger test results posted to test rail
- Ensure the correct chromedriver depending on environment specified through Maven commands

#### Step Definition Feature File 
- Java class whereby the steps from  the feature file are broken down to be coded into automation tests

#### Feature Model Class 
- Java class whereby the step definition calls on methods that require action from the automated user such as entering text, finding/asserting fields on the UI

#### Feature PageObject Class 
- Java class whereby the necessary HTML objects are captured as WebElements to be manipulated by the associated model class

#### ChromeDriver.exe 
- Local chromedriver necessary in order 

#### Cucumber Reports 
- Cucumber has a built in report generation whereby Feature files tested are automatically written to cucumbers own reporting system 

## Steps to write an acceptance test
```
Each Feature file has it???s step defition, pageobject & model class
              
   1- Create Feature file and define feature scenario test & Testrail ID???s
              
   2- Run project and copy method stubs from output
              
   3- Create Step definition class & paste method stubs
              
   4- Create Page Object Class and define objects required
              
   5- Create Runner Class & Define actions require with page objects
              
   6- Instantiate model object in Step definition & execute tests required per step
```

## Maven Dependencies
```
	<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
	
	<dependencies>
		<!-- https://mvnrepository.com/artifact/net.masterthought/maven-cucumber-reporting -->
		<dependency>
			<groupId>com.sun</groupId>
			<artifactId>tools</artifactId>
			<version>1.8</version>
			<scope>system</scope>
			<systemPath>C:\Program Files\Java\jdk1.8.0_172\lib\tools.jar</systemPath>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope></scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-core -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-core</artifactId>
			<version>7.11.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-html -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-html</artifactId>
			<version>0.2.7</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>7.11.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>7.11.0</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-jvm-deps</artifactId>
			<version>1.0.6</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.7.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
		<dependency>
			<groupId>net.masterthought</groupId>
			<artifactId>cucumber-reporting</artifactId>
			<version>5.7.4</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/net.sourceforge.cobertura/cobertura -->
		<dependency>
			<groupId>net.sourceforge.cobertura</groupId>
			<artifactId>cobertura</artifactId>
			<version>2.1.1</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>gherkin</artifactId>
			<version>26.0.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest-core -->
		<dependency>
			<groupId>org.hamcrest</groupId>
			<artifactId>hamcrest-core</artifactId>
			<version>2.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.9</version>
				<configuration>
					<testFailureIgnore>true</testFailureIgnore>
				</configuration>
			</plugin>
			<plugin>
				<groupId>net.masterthought</groupId>
				<artifactId>maven-cucumber-reporting</artifactId>
				<version>3.16.0</version>
				<executions>
					<execution>
						<id>execution</id>
						<phase>verify</phase>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<projectName>AutomationDevelop</projectName>
							<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
							<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

## Folder Structure

## Test Runner Configuration

```
	- @RunWith(Cucumber.class)
	- ucumberOptions(
	-	features = "api.feature",
	-	glue = "stepDefinitions",
	-	dryRun = false,
	-	monochrome = true,
	-	plugin = {"pretty","json:target/cucumber-api.json","html:target/cucumber-html-report-api",
	-			"junit:target/cucumber-api.xml"}
	-	)

	- public class TestApiRunner {
	
	- }
```

## Execution Steps

```
	1. Open eclipse IDE
	2. Navigate to the folder src/test/java and click on it
	3. Go to the package testRunner
	4. Right click on this and select Run as Junit
```

## API Automation Test BDD framework

API Automation Test is RestAssured based Cucumber framework to perform API testing. This project is useful as an example of API Testing with RestAssured and Java playing nicely together.

### Getting Started

1. git clone https://github.com/git-wasim/AutomationDevelop.git
2. Navigate to AutomationDevelop
In terminal from root project folder (RestasssuredCucumber), run below commands as required

### Run Tests

To run all features mvn clean test verify
To pass environment variable from command line mvn clean test verify -DargLine=-DWSNSHELL_HOME=RSURI RSRUI is environment passed in src-> test-> java-> base-> CryptoAPI.java and defined in config.properties
Report Path

### Cucumber HTML Report: 
{ROOT_PROJECT_FOLDER}/target/cucumber-html-reports/overview-features.html

### Key Features
- Runtime environment set
- Hashmap to simplify serialization of payload
- Tag based execution
- Detailed Cucumber Report
- Header builder simplified
- Reusable methods to perform GET, POST operations

