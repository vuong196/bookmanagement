

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		Book book=new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		
		System.out.println(name);
		System.out.println(author);
		int status=BookDAO.update(book);
		
		if(status>0){
			response.sendRedirect("view");
		}else{
			out.println("Sorry! unable to update this book");
		}
		
		out.close();
	}

}
