# api-spring-boot-framework
API Back-end automation framework using spring dependencies , Junit-5 test runner , allure reporting , and maven build tool

1. Install **Maven** and Import as Maven project in IntelliJ or Eclipse

2. **Framework Structure:**
     - **_httprequests:_** All API Requests
     - **_data:_** Test data - in ENUMS
     - **_dtos:_**  Dynamically Generated Request -Gson and Response DTOS
     - **_providers:_** De-seralized provider methods
     - **_utils:_**  Commonly used methods
     - **_tests:_** All Test cases 
     - **_steps:_** Business logic defined for test cases

3. **Command to run all scenarios:**
    ```bash
    mvn clean test

4. **Report Generation command:**
    cd to the target folder and run the following command
    ```bash
    allure serve
    ```
    For Windows, 
    
    In order to generate a report, we should install Allure command-line interpreter.
    
    Download the latest version as a zip archive from bintray: https://bintray.com/qameta/generic/allure2/2.7.0#files/io%2Fqameta%2Fallure%2Fallure%2F2.7.0
    Unpack the archive.
    Navigate to the bin directory.
    Add allure’s bin directory to system Path variable.
    
    
