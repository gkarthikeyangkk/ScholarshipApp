# ScholarshipApp
Spring Boot Web App

## Prerequisites
	Eclipse
	Maven as eclipse plug-in
	MySQL v6.3 (Please install MySQL Workbench as well to execute the script. Execute script located in path <<Proect Root Directory>>\src\main\sqlscripts\DDLScript.sql)
	
## Steps to import this Maven project and run the application
	1.	Import this project from Github - Copy the git URL of this project
	2.	Go to Eclipse>File>Import> Select "Projects from Git"> your copied URL would be automatically pasted. Go next, next but don't finish
	3.	Note down the location in the windows file system where the project is imported
	4.  	Go to Eclipe>File>Import> type Maven> Select "Existing Maven Projects"> Browse to the windows file system where you have kept the project imported from git > Click Finish
	5.  	Maven project would be built. Right click on that project in Project Explorer. Click "Maven". Click "Update Project". Project would download all the dependencies.
	6.	Right click again on the project. Click "Run As". Click "Maven clean"
	7.	Right click again on the project. Click "Run As". Click "Maven install" to create jar file for this application
	8.	Open ScholarshipAppApplication.java file located in src/main/java/com/tripleS path. Right click on the editor and select Run As "Java Application"
	9.	Spring boot application would be seen as started in the console logs.
	10. 	Go to http://localhost:8080/
	
	
