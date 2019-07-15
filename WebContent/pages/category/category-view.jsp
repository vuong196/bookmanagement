<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="daos.CategoryDAO" %>
<%@ page import="beans.Category" %>
<%@ page import="java.util.List" %>
<%
	String id = request.getParameter("id");
	List<Category> categories = CategoryDAO.getAllCategories();
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Category</title>
 
<style type="text/css">
	body{
		text-align: center;
	}
	table {
		margin-left: 15%;
		min-width: 70%;
		border: 1px solid #CCC;
		border-collapse: collapse;
	}
	table tr{line-height: 30px;}
	table tr th { background: #000033; color: #FFF;}
	table tr td { border:1px solid #CCC; margin: 5px;}
	input[type=text], input[type=email], input[type=tel]{
		min-width: 60%;
	}
	input[type=submit], a{
		background: green;
		padding: 5px;
		margin: 5px;
		color: #FFF;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<center><h1> Category List </h1>
	<table border='1' cellpadding='4' width='60%'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Features</th>
		</tr>
		<% for (Category c : categories) { %>
			<tr>
				<td><%=c.getCategoryId()%></td>
				<td><%=c.getCategoryName()%></td>
				<td>
				<center>
					<a href="edit?id=<%=c.getCategoryId()%>">Edit</a>
					<a href="delete?id=<%=c.getCategoryId()%>">Delete</a>
				</center>
			</td>
			</tr>
		<% } %>
	</table>
	</center>
	<br/>
	<center>
		<a href='add'> Add New Author </a>
	</center>"
	<a href='../index.jsp'>Homepage</a>
</body>
</html>
