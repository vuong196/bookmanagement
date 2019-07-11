
package servlets.author;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Author;
import daos.AuthorDAO;;

@WebServlet("/EditAuthorFormServlet")
public class EditForm extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Author</h1>");
		String id = request.getParameter("id");
		try {
			Author a = AuthorDAO.getAuthorById(id);
			out.print("<form action='EditServlet' method='post'>");
			out.print("<table>");
			out.print("<tr>"
				+ "<td>Id:</td>"
				+ "<td><input type='text' name='id' value='" + a.get_authorId() + "' readonly/></td>"
				+ "</tr>");
			out.print("<tr>"
				+ "<td>Name:</td>"
				+ "<td><input type='text' name='name' value='" + a.get_authorName() + "' required/></td>"
				+ "</tr>");
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