cp ../HelloWorld/build.* .

rm license.txt notice.txt 
rm -rf bin/

mkdir -p war/WEB-INF/classes/
cd war/WEB-INF/classes/
mkdir xml
mv ../../../src/beans.xml ./xml

vi Main.java
  change bean.xml to xml/bean.xml

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

cd ~/hdrive/workspace/spring_examples/exp1/war/WEB-INF/classes 
ln -s ../../../src/beans.xml .

export CLASSPATH=./war/WEB-INF/classes:~/hdrive/workspace/lib/*
java com.vaannila.HelloWorldApp

--
-- or 
--

export CLASSPATH=./war/WEB-INF/classes:~/hdrive/workspace/lib/*:./src/
java com.vaannila.HelloWorldApp


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
for Tomcat:

cp ../AnnoController/build.* .
rm license.txt notice.txt

find . -name '*.java'

mkdir src
mkdir src/domain
mkdir src/service
mkdir src/web

mv ./WEB-INF/classes/com/vaannila/domain/*.java src/domain/
mv ./WEB-INF/classes/com/vaannila/service/*.java src/service/
mv ./WEB-INF/classes/com/vaannila/web/*.java src/web/

vi build.xml
  change springapp to the app name you're going to use
ant deploy

cd ~/apache-tomcat-6.0.32/webapps/MVC/WEB-INF
cp -rp ~/spring/dist lib

http://cchoudesktop.cardiodx.com:8080/MVC/




