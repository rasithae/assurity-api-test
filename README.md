<h1 align="center"><b> Assurity Assesment </b></h1>

## Requirement
Using the API given below create an automated test with the listed acceptance criteria:

**API** = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false
 
**Acceptance Criteria:**
1. Name = "Carbon credits"
2. CanRelist = true
3. The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"


## Automation Solution

The given API was automated using JAVA programming language and RestAssured as the API automation library following the coding best practices. The solution is extendable and highly maintainable.

## Libraries & Dependency Versions

Following libraries and dependencies are used in this solution

| :blue_book: Library                 | :scroll: Purpose      | :bow_and_arrow: Version        |
| :-------------          |:------------| :------------- |
| `Java Development KIT 8`  |*Development environment for programs written in Java language*|    `JDK 8u341`    |
| `Rest-Assured`            |*Library for testing and validating REST services in Java* | `4.5.1`  |
| `TestNG`                  |*Testing framework for Java covering a range of test categories: unit, functional, end-to-end*| `7.1.0`  |
| `Extent Reports`          |*Library to create beautiful, interactive and detailed reports for automated tests*| `4.0.9`  |
| `Apache Maven`            |*Maven is a build automation tool used primarily for Java projects*| `3.3.9`  |


## How to Setup the Execution Environment (Prerequisites)

Before executing the test script, you have to install the prerequisite software in your execution machine. You can follow the steps below to setup the execution environment.

1. Download and Install JDK 8 
2. Download Install [Eclipse IDE](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/neon/3/eclipse-rcp-neon-3-win32-x86_64.zip) 
3. Install the TestNG plugin for Eclipse from the marketplace

Note: You can also use an IDE like IntelliJ IDEA 

## How to Execute the Test

Please follow the steps given below to execute the test script:

1.	Clone this git repository into your local machine
2.	Open Eclipse IDE
3.	Import the maven project into Eclipse

    Eclipse will automatically start downloading the required maven dependencies. Wait until it finishes and the project is free of any compilation errors.
    
    **Note:** If you see compilation errors, please do a maven force update to retry the dependency download.
    
4.	Once the project is ready, open src/test/java folder & navigate to com.assurity.test package
5.	Open APITest.java class (This is where the API test is written)
6.	Right click -> Run As -> TestNG Test

    Test will start to execute and after some time, the test will complete and you will see a message with the test result in the console

## View Test Results Report

1.	Once the test execution is complete, open the project folder and you will find a new folder named “reports”. This is where the generated HTML report is saved. 
2.	Inside the folder, you will find a subfolder with the name  **_“ASSURITY_Test_Report_dd_MM_yyyy_HH_mm_ss”_**.
3.	Open the **_ASSURITY_Test_Execution_Summary.html_** file inside and the report will open in your browser.

## Best Practices Followed

1.	Well commented code.
2.	Maintaining a good packaging structure for better code organization.
3.	Constant data moved into a constant file to make the code more readable and maintainable.
4.	API related configuration details are stored in “config.properties” file to easily update if the URL details change.
5.	Followed standard java coding guidelines. 
6.	Logs incorporated into the Extent report for further debugging if needed.
7.	Used a BaseTest class which contains setup, loading configuration and other reusable methods.

