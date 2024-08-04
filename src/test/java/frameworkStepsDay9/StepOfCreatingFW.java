package frameworkStepsDay9;

/*
Framework Objective:
	1.Re-usability
	2.Maintainability
	3.Readability
	
Hybrid Driven:
		
Phases:
------------------------------
1. Understanding Requirement:
-Functional Speciification
-Swagger 

2.Choose Automation Tool -- Rest Assured Library

3.Design 

4.Developement

5.Execution + CI



------FRamework design:
Pre-Req----
1. Create Maven project
2.Update pom.xml with required dependencies
3. Create folder structure
Design and developement of FW----
4. Create routes.java---contains urls
5. Create user endpoint.java -->contains crud method implementation --creating methods
6. TestCase creation  	
7. Create Data driven test
 - excel sheet data required
 -Excel utility file
 -DataPRoviders
 
 8. Generate Extend Reports 
  - Extent report utility class // this we will keep in testng xml file
  -testng.xml file
  steps:
  ->add extent report dependency
  ->Create a utility file which will generate the report under utility package.
  (here executing testng xml file it will keep running tests and also ERM report -methods to generate report.
 
 -> create testng xml file inside test folder(convert  to TESTNG) then integrate the exten report
 
 9. Add logs
 -log4j dependency
 -log4j2.xml file==log related to config part of srstest resources
 
 
 
 
 
 
 
 
*/