package servlets.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Author;
import beans.Book;
import beans.Category;
import daos.AuthorDAO;
import daos.BookDAO;
import daos.CategoryDAO;
@WebServlet("/AddBookFormServlet")
public class AddForm extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);

		PrintWriter out = response.getWriter();

		List<Category> categories = CategoryDAO.getAllCategories();
		List<Author> authors = AuthorDAO.getAllAuthors();

		out.print("<center><h1>Add New Book</h1>");
		out.print("<form action='AddServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' required/></td></tr>");

		out.print("<tr><td>Category:</td><td><select name='category'>");
		for(Category c : categories) {
			out.print("<option value ='"+ c.get_categoryId()+ "'>"+ c.get_categoryName()+ "</option>");
		}
		out.print("</select></td></tr>");

		out.print("<tr><td>Author:</td><td><select name='author'>");
		for(Author a : authors) {
			out.print("<option value ='"+ a.get_authorId()+ "'>"+ a.get_authorName()+ "</option>");
		}
		out.print("</select></td></tr>");

		out.print("<tr><td colspan='2'><input type='submit' value='Add Book'/></td></tr>");
		out.print("</table>");
		out.print("</form></center>");

		out.close();
	}
}