<%@page import="details.Student"%>
<%@page import="details.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Teacher</title>
</head>
<body>
<%List<Student>t=(List)session.getAttribute("Student"); %>
<table cellpadding="20px" border="1">
  <th>S_id</th>
  <th>S_Name</th>
  <th>S_Stream</th>
  <th>S_Yop</th>
  
 <%for(Student w:t){%>
 <tr align="center">
 <td><%= w.getId() %></td>
 <td><%= w.getName() %></td>
 <td><%= w.getStream() %></td>
 <td><%= w.getYop() %></td>
 </tr>
 <%} %>
 </table>
 <a href="Student.html"><input type="button"value="Main-Menu"></a>

</body>
</html>