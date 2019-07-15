
package servlets.author;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddAuthorFormServlet")
public class AddForm extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		out.print("<center><h1>Add New Author</h1>");
		out.print("<form action='AddServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' required/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Add Author'/></td></tr>");
		out.print("</table>");
		out.print("</form></center>");
		out.close();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}