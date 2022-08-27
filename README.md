
A Standalone Java Application named WPHHomeTest developed using:  
* gradle
* StringUtils Library for Standard String operations
* JDK 1.8 Library
* Junit 5.6 Library for Unit Test Cases

## How to run the Application
Two ways to run the application through pre-build(using jar)[WPHHomeTest/docs/WPHHomeTest-1.0.1-SNAPSHOT.jar]
or By importing project. I used intelliJ Ide to develop this application.


### Pre-requisites
* JRE 14
* gradle  
* File(Data File) on local drive location


### Through Jar  
1. set path to Jar file [WPHHomeTest-1.0.1-SNAPSHOT.jar]
2. Run the jar file using below command:
```
java -jar WPHHomeTest-1.0.1-SNAPSHOT.jar "fileLocation/fileName" "X"
```
* pass fileLocation as the location of the Data file(stored on your local system drive) and fileName as the name of the file as argument to java jar statement.
* pass the valid value of 'X'. 'X' is a number/numeric value

Example: (Run the command on cmd for Windows and on Terminal for Mac OS)
java -jar WPHHomeTest-1.0.1-SNAPSHOT.jar "user/testuser/data/Sample.txt" "3"

Here fileLocation = user/testuser/data and fileName = Sample.txt and X = 3
***  

### By Importing in IntelliJ IDE  
 1. Download the project and unzip in local system.
 2. Open intelJ.
 3. click file > Open
 4. Click Browse and select the folder that was unzipped in step 1
 5. click open.
 6. Modify the config.properties file(present in /WPHHomeTest/src/main/resources/) to include the location of the file against the key 'FileLocation' and numeric value against the key 'X'
* The config.properties file should look like this below:
```
FileLocation=/WPHHomeTest/src/main/resources/Sample.txt
X=3
```

