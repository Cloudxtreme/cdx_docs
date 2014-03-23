Reverse Engineer Waban to generate Java Beans
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
start eclipse

New -> Project -> java Project
  Waban2
  Libraries -> Add External JARs
    -> hdrive/workspace/lib

New -> Hibernate Configuration File
   <session-factory>
        <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
        <property name="hibernate.connection.password">desktop30dna</property>
        <property name="hibernate.connection.url">jdbc:oracle:thin:@desktop30:1521:orcl</property>
        <property name="hibernate.connection.username">dnalims</property>
        <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
        <property name="hibernate.search.autoregister_listeners">false</property>
    </session-factory>

New -> Hibernate Console Config
    Name: Waban2
	Project: Waban2
	Config file: /Waban2/src/hibernate.cfg.xml
	Database dialet: Oracle 10g
    Finish

New Hibernate Reverse Engineering file
	Waban2/src
	hibernate.reveng.xml
    Next
	Console Configuration: Waban2
	Database Schema: [Refresh] 
	Finish

    Table Filter: 
		Database Schema: [Refresh] w/o filter at this time
		Exclude all system schemas
		(Remember to 'exclude' first then 'include'.)		
  
Click 'hibernate' button -> Hibernate Code Generatioin Configuration
  Click 'new' button to create a new configuration
  	Name: Waban2
	Console configuration: Waban2
	Output directory: /Waban2/src
	Reverse engineer from JDBC Connection
		Package: 	com.cardiodx.db.waban
		reveng.xml: /Waban2/src/hibernate.reveng.xml
	Exports:
		Use Java5 Syntax
		Exports:
			Domain code(.java)
			Hibernate XML Mappings (.hbm.xml)
			DAO code (.java)
	Apply
	Run





