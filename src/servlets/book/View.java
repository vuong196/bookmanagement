
package servlets.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Book;
import beans.Category;
import daos.BookDAO;
@WebServlet("/ViewBookServlet")
public class View extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		try {
			List<Book> books = BookDAO.getAllBooks();
			out.print("<center><h1> Book List </h1>");
			out.print("<table border='1' cellpadding='4' width='60%'>"
				+ "<tr><th>Name</th><th>Author</th><th>Categories</th><th>Actions</th></tr>");
			for (Book b : books) {
				System.out.println(b.getBookAuthor().getAuthorName());
				out.print("<tr>"
					+ "<td>" + b.getBookName() + "</td>"
					+ "<td>" + b.getBookAuthor().getAuthorName() + "</td>"
					+ "<td><center>");
				for (Category c : b.getBookCategorySet()) {
					out.print("<label>" + c.getCategoryName() + "</label>");
				} ;
				out.print("<td><center>"
					+ "<a href='edit?id=" + b.getBookId() + "'>Edit</a>  "
					+ "<a href='delete?id=" + b.getBookId() + "'>Delete</a>"
					+ "</center></td>"
					+ "</tr>");
			}
			out.print("</table></center><br/>");
			out.println("<center><a href='add'> Add Book </a></center>");
			out.print("<a href='../index.html'>Homepage</a>");
			out.close();
		} catch (Exception e) {
			out.println("Caught error: " + e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}
