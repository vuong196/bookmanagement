
package servlets.author;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AuthorDAO;

@WebServlet("/DeleteAuthorServlet")
public class Delete extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			boolean status = AuthorDAO.delete(id);
			if (status) {
				response.sendRedirect("view");
			}
			else {
				out.println("Sorry! unable to delete this author");
			}
		}
		catch (Exception e) {
			out.println("Sorry! unable to delete this author");
		}
		out.close();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}