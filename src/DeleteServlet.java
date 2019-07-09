
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

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
		String id = request.getParameter("id");
		try {

			int status = BookDAO.delete(id);

			if(status > 0) {

				response.sendRedirect("view");
			}
			else {

				out.println("Sorry! unable to update this book");
			}
		}
		catch (Exception e) {

			out.println("Sorry! unable to update this book");
		}

		out.close();
	}
}