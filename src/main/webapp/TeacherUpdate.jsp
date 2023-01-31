<%@page import="details.Teacher"%>
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

	
	Teacher t=Helper.em.find(Teacher.class, id1);
	%>

	<form action="tupdate" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		stream: <input type="text" value="<%=t.getSubject()%>" name="subject">
		Yop: <input type="text" value="<%=t.getSal()%>"name="sal">
		<input type="submit">
	</form>


	

</body>
</html>