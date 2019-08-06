<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="beans.Author" %>
<%@ page import="beans.Book" %>
<%@ page import="beans.Category" %>
<%@ page import="daos.AuthorDAO" %>
<%@ page import="daos.BookDAO" %>
<%@ page import="daos.CategoryDAO" %>
<%
	String id = request.getParameter("id");
	Book book = BookDAO.getBookById(id);
	List<Category> categories = CategoryDAO.getAllCategories();
	List<Author> authors = AuthorDAO.getAllAuthors();
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
	<h1>Add New Book</h1>
	<form action='EditServlet' method='post'>
		<table>
			<tr>
				<td>Id:</td>
				<td><input type='text' name='id' value='<%=book.getBookId()%>' readonly/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type='text' name='name' required/></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td>
					<select name='category' selected='<%=book.getBookCategorySet().iterator().next().getCategoryId() %>'>
						<% for (Category c : categories) { %>
							<option value ='<%=c.getCategoryId()%>'><%=c.getCategoryName() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>Category:</td>
				<td>
					<select name='author' selected='<%=book.getBookAuthor().getAuthorId() %>'>
						<% for (Author a : authors) { %>
							<option value ='<%=a.getAuthorId()%>'><%=a.getAuthorName() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr><td colspan='2'><input type='submit' value='Add Book'/></td></tr>
		</table>
	</form>
</body>
</html>
