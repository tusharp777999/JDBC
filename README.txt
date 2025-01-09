In Mac system start the MySql server manually.
System Setting -> MySql in side menu at bottom side scroll down -> click on start My Server.

In Mac system if MySql gives access denied error please use following command.
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
FLUSH PRIVILEGES;

Delete the following file from Java Project.
module-info.java
