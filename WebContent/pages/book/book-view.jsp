<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="beans.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Author" %>
<%@ page import="beans.Book" %>
<%@ page import="beans.Category" %>
<%@ page import="daos.AuthorDAO" %>
<%@ page import="daos.BookDAO" %>
<%@ page import="daos.CategoryDAO" %>
<%
	String id = request.getParameter("id");
	List<Book> books = BookDAO.getAllBooks();
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Book</title>
 
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
	<center><h1> Book List </h1>
	<table border='1' cellpadding='4' width='60%'>
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Categories</th>
			<th>Author</th>
			<th>Actions</th>
		</tr>
		<%for (Book b : books) { %>
				<tr>
					<td><%=b.getBookName() %></td>
					<td><%=b.getBookAuthor().getAuthorName() %></td>
					<td><center>
				<% for (Category c : b.getBookCategorySet()) { %>
					<label><%=c.getCategoryName() %></label>
				<% } %>
				<td><%=b.getBookAuthor().getAuthorName() %></td>
				<td><center>
					<a href='edit?id=<%=b.getBookId()%>'>Edit</a>
					<a href='delete?id=<%=b.getBookId()%>'>Delete</a>
					</center></td>
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
