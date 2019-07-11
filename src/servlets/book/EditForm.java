
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
@WebServlet("/EditBookFormServlet")
public class EditForm extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Book</h1>");
		String id = request.getParameter("id");
		try {
			Book book = BookDAO.getBookById(id);
			List<Category> categories = CategoryDAO.getAllCategories();
			List<Author> authors = AuthorDAO.getAllAuthors();
			out.print("<form action='EditServlet' method='post'>");
			out.print("<table>");
			out.print("<tr>"
				+ "<td>Id:</td>"
				+ "<td><input type='text' name='id' value='" + book.get_bookId() + "' readonly/></td>"
				+ "</tr>");
			out.print("<tr>"
				+ "<td>Name:</td>"
				+ "<td><input type='text' name='name' value='" + book.get_bookName() + "' required/></td>"
				+ "</tr>");
			out.print("<tr><td>Category:</td><td><select name='category'>");
			for (Category c : categories) {
				out.print("<option value ='" + c.get_categoryId() + "'>" + c.get_categoryName() + "</option>");
			}
			out.print("</select></td></tr>");
			out.print("<tr><td>Author:</td><td><select name='author' selected='" + book.get_bookAuthor().get_authorId()
				+ "'>");
			for (Author a : authors) {
				out.print("<option value ='" + a.get_authorId() + "'>" + a.get_authorName() + "</option>");
			}
			out.print("</select></td></tr>");
			out.print("<tr>"
				+ "<td colspan='2'><input type='submit' value='Edit &amp; Save '/></td>"
				+ "</tr>");
			out.print("</table>");
			out.print("</form>");
		} catch (Exception e) {
			out.println("Caught error: " + e);
		}
		out.close();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}