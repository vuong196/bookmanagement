package servlets.category;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import daos.CategoryDAO;;
@WebServlet("/EditCategoryFormServlet")
public class EditForm extends HttpServlet {

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
		out.println("<h1>Update Category</h1>");
		String id = request.getParameter("id");

		try {

			Category c = CategoryDAO.getCategoryById(id);

			out.print("<form action='EditServlet' method='post'>");
			out.print("<table>");
			out.print("<tr>"
					+ "<td>Id:</td>"
					+ "<td><input type='text' name='id' value='" + c.get_categoryId() + "' readonly/></td>"
					+ "</tr>");
			out.print("<tr>"
					+ "<td>Name:</td>"
					+ "<td><input type='text' name='name' value='" + c.get_categoryName() + "' required/></td>"
					+ "</tr>");
			out.print("<tr>"
					+ "<td colspan='2'><input type='submit' value='Edit &amp; Save '/></td>"
					+ "</tr>");
			out.print("</table>");
			out.print("</form>");
		}
		catch(Exception e) {

			out.println("Caught error: " + e);
		}

		out.close();
	}
}