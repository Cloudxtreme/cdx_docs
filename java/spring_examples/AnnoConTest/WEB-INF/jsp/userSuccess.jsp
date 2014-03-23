<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
User Details
<hr>
User Name   : ${hello.name} <br/>
Gender      : ${hello.gender} <br/>
Country     : ${hello.country} <br/>
About You   : ${hello.aboutYou} <br/>
Community   : ${hello.community[0]}  ${hello.community[1]} ${hello.community[2]}<br/>
Mailing List: ${hello.mailingList} 
</body>
</html>
