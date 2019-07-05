
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        
        List<Book> list = BookDAO.getAllBooks();
        
        out.print("<center><h1> Book List</h1>");
        out.print("<table border='1' cellpadding='4' width='60%'><tr><th>Name</th><th>Author</th><th>Features</th></tr>");  
        for(Book b:list){  
            out.print("<tr>"
            		+ "<td>"+b.getName()+"</td>"
            		+ "<td>"+b.getAuthor()+"</td>"
            		+ "<td><center>"
        			+ "<a href='edit?id="+b.getId()+"'>Edit</a>  "
            		+ "<a href='delete?id="+b.getId()+"'>Delete</a>"
            		+ "</center></td>"
            		+ "</tr>");  
        }  
        out.print("</table></center><br/>");
        out.println("<center><a href='add'> Add Book </a></center>");
        out.close();
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
	}
}



