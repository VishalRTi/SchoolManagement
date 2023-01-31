<%@page import="details.Student"%>
<%@page import="helper.Helper"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);

	
	Student s=Helper.em.find(Student.class, id1);
	%>

	<form action="updatet" method="post">
		id: <input type="text" value="<%=s.getId()%>" name="id">
		name: <input type="text" value="<%=s.getName()%>" name="name">
		stream: <input type="text" value="<%=s.getStream()%>" name="stream">
		Yop: <input type="text" value="<%=s.getYop()%>"name="yop">
		<input type="submit">
	</form>


	

</body>
</html>