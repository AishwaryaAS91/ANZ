1)Kindly import the project “CucumberJava” to Eclipse.
2)Two scenarios are designed in this project.
Scenario	Feature file	Path of feature file
To register a new user 	newUserRegister.feature	src\test\resources\Features\newUserRegister.feature
To add Casual Dresses to cart	payment.feature	src\test\resources\Features\payment.feature

Input for both scenarios have been provided using ‘Examples’ in feature file. Please provide a new email address <emailaddress> at step 19 before executing “newUserRegister.feature” file.
3)Execution of test cases:
All dependencies have been provided in pom.xml file. Go to pom.xml->Right click->Run as->Maven test.
This will run both the scenarios in sequence.
4)Allure report:
Results will be generated as allure json files under “target/allure-results”.
To view the report in local machine, please download allure commandline interpreter from https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline and execute the below command.
<path of allure commandline bin folder>\allure.bat serve <path of result folder>
Example:
C:\Work\allure-2.13.0\bin\allure.bat serve C:\Users\002GHL744\git\ANZ_new\CucumberJava\target\allure-results




