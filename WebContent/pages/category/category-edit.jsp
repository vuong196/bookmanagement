<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="daos.CategoryDAO" %>
<%@ page import="beans.Category" %>
<%
	String id = request.getParameter("id");
	Category c = CategoryDAO.getCategoryById(id);
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Category</title>
 
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
	<h1>Edit Category</h1>
	<form action='EditServlet' method='post'>
		<table>
			<tr><td>Id:</td><td><input type='text' name='id' value='<%=c.getCategoryId()%>' required readonly/></td></tr>
			<tr><td>Name:</td><td><input type='text' name='name' value='<%=c.getCategoryName() %>' required/></td></tr>
			<tr><td colspan='2'><input type='submit' value='Edit Category'/></td></tr>
		</table>
	</form>
</body>
</html>
