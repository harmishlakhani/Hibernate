Hibernate
=========

This repo contains hands on on basics of hibernate(date persistence framework) for J2EE.

I will create simple POC for some basic CRUD(create, read, update and delete) operations and how hibernate will interact with database. Here I am using Oracle 11g express edition as a DB. You can use your own chosen DB.

Required Tools/Jars:
* Download latest hibernate distribution zip file from http://hibernate.org/orm/downloads/ (current version is 4.3.5)
* Download the JDBC driver for Oracle 11g from http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
* Last but not least you need JDK and IDE(Eclipse if you love :P).

It contains POCs according to classification like insert, update , delete and based on Annotaions as well.

## How to add Hibernate jars dependency
First of all unzip the hibernate distribution zip file downloaded from above steps.
Following are the steps for Eclipse
* Right Click on project -> Properties
* Click on Java Build Path
* Go to Libraries tab
* Click on Add Library
* Select User Library(we keep all the jars in one user defined library which we add as a dependency)
* Click on User Libraries
* Click on Add and give meaningful name like Hibernate
* Click on Add External JARS and go to unzipped hibernate distribution folder
* select all the jars which are in (unzipped folder)/lib/required and  (unzipped folder)/lib/jpa
* Click Finish and OK

Now you are able to see all the jars in your project -> Hibernate library. You need to add one more jar(JDBC Driver according to your DB). I have use ojdbc6.jar (Oracle 11g XE).
Follow below steps
* Right Click on project -> Properties
* Click on Java Build Path
* Go to Libraries tab
* Click on Add External JARS and add the ojdbc6.jar(JDBC Driver for Oracle 11g)
* Click OK

Ojdbc6.jar is for JDK >= 6. Choose driver accrording to your JDK version.
That's it. Now you are able to use all the required class and methods that are required to use Hibernate

Happy coding.
