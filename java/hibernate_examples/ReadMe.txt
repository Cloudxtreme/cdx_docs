http://www.vaannila.com/hibernate/hibernate-example/hibernate-tools-1.html

for generating Java objects:
  start eclipse
  1) File -> New -> project -> Java -> Java Project
     Library -> Add External jars --> hdrives/workspace/lib/*

  2) New -> Hibernate XML Mapping file 
      example1/src/com/vaannila/course
	  Course.hbm.xml

  3) New -> Hibernate Configuration File
      example1/src
	  hibernate.cfg.xml

  4) New -> Hibernate Console Configuration 
	  Core
	  Project: example1
	  Configuration file: example1/src/hibernate.cfg.xml

  5) Run -> Hibernate Code Generation Configurations...
	  Console config: example1 (created above)
	  Output Dir: example1/src
	  Exports tab:
		Use Java 5 Syngax
		Domain code (.java)
	  Click Run
