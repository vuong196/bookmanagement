package servlets.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import daos.CategoryDAO;
@WebServlet("/ViewCategoryServlet")
public class View extends HttpServlet {
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
		try {

			List<Category> categories = CategoryDAO.getAllCategories();
			out.print("<center><h1> Category List </h1>");
			out.print("<table border='1' cellpadding='4' width='60%'>"
					+ "<tr><th>Id</th><th>Name</th><th>Features</th></tr>");
			for(Category c:categories) {

				out.print("<tr>"
						+ "<td>"+c.get_categoryId()+"</td>"
						+ "<td>"+c.get_categoryName()+"</td>"
						+ "<td><center>"
						+ "<a href='edit?id="+c.get_categoryId()+"'>Edit</a>  "
						+ "<a href='delete?id="+c.get_categoryId()+"'>Delete</a>"
						+ "</center></td>"
						+ "</tr>");
			}
			out.print("</table></center><br/>");
			out.println("<center><a href='add'> Add New Category </a></center>");
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
}



