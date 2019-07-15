
package servlets.category;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.CategoryDAO;
@WebServlet("/DeleteCategoryServlet")
public class Delete extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 2L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			boolean status = CategoryDAO.delete(id);
			if (status) {
				response.sendRedirect("view");
			} else {
				out.println("Sorry! unable to update this category");
			}
		} catch (Exception e) {
			out.println("Sorry! unable to update this category");
		}
		out.close();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	}
}