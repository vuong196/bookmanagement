
package servlets.author;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Author;
import daos.AuthorDAO;

@WebServlet("/ViewAuthorServlet")
public class View extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		try {
			List<Author> authors = AuthorDAO.getAllAuthors();
			out.print("<center><h1> Author List </h1>");
			out.print("<table border='1' cellpadding='4' width='60%'>"
				+ "<tr><th>Id</th><th>Name</th><th>Features</th></tr>");
			for (Author a : authors) {
				out.print("<tr>"
					+ "<td>" + a.getAuthorId() + "</td>"
					+ "<td>" + a.getAuthorName() + "</td>"
					+ "<td><center>"
					+ "<a href='edit?id=" + a.getAuthorId() + "'>Edit</a>  "
					+ "<a href='delete?id=" + a.getAuthorId() + "'>Delete</a>"
					+ "</center></td>"
					+ "</tr>");
			}
			out.print("</table></center><br/>");
			out.println("<center><a href='add'> Add New Author </a></center>");
			out.print("<a href='../index.html'>Homepage</a>");
			out.close();
		}
		catch (Exception e) {
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
