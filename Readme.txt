java version "1.8.0_144"
Tomcat version: 8.5
I’ve been using eclipse EE version: 2020-03 (4.15.0) but it should work for any java IDE.
First of all, download jdk for corresponding system by using following link.
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
The second one is installation instruction.

Besides that, download and install tomcat from this link:
https://tomcat.apache.org/download-80.cgi

After all, set the java server to tomcat 8.5
Eclipse – Pereference – server - runtime environments – add tomcat 8.5

Import – General – Existing projects into workspace (move the project into workspace ahead)

Then right click on the project – run as – run on server (select tomcat 8.5 if anything pops up) then you should be able to see the web page. Fill in all the information it will calculate BMR and calorie. 



