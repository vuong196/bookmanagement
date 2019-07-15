
package servlets.book;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.BookDAO;
@WebServlet("/AddBookServlet")
public class Add extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String author = request.getParameter("author");
		try {
			boolean status = BookDAO.save(name, category, author);
			if (status) {
				response.sendRedirect("view");
			}
			else {
				out.println("Sorry! unable to add this book");
			}
		}
		catch (Exception e) {
			out.println("Caught error when adding:" + e);
		}
		out.close();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}
