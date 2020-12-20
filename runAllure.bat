set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReport\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllureReport\*;%ProjectPath%libExtentVersion4\*;%ProjectPath%libLog4J\*;%ProjectPath%libSelenium\*;%ProjectPath%libReportNG\*;%ProjectPath%WebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runUserTestcases.xml"
allure serve allure-json