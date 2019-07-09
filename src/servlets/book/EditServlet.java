package servlets.book;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import daos.BookDAO;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	private static final long _SERIAL_VERSION_UID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		processRequest(request, response);

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		try {

			boolean status = BookDAO.update(id, name, author);

			if(status) {

				response.sendRedirect("view");
			}
			else {

				out.println("Sorry! unable to update this book");
			}
		}
		catch (Exception e) {

			out.println("Caught error when updating: " + e);
		}
		out.close();
	}

}

