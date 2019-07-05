import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditFormServlet")
public class EditFormServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Book</h1>");
		String id=request.getParameter("id");
		Book book=BookDAO.getBookById(id);
		
		out.print("<form action='EditServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Id:</td><td><input type='text' name='id' value='" + book.getId() + "' readonly/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + book.getName() + "' required/></td></tr>");
		out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthor() + "'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}