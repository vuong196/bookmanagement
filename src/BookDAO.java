import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private static List<Book> list = new ArrayList<Book>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		 add(new Book("The Maze Runner", "James Dashner"));
		 add(new Book("The Hunger Game", "Suzanne Collins"));
		 add(new Book("Divergent", "Veronica Roth"));
	 }};
 
    public static int save(Book book){
		int status=0;
		list.add(book);
		status = 1;
		return status;
	}
    
    public static int update(Book book){
		int status=0;

		for(Book b:list)
			if (book.getId().equals(b.getId())){
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
				status = 1;
				return status;
			}
		return status;
	}
    
    public static int delete(String id){
		int status = 0;
		
		for (int i = 0; i< list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.println(id);
				list.remove(i);
				status = 1;
				return status;
			}
		}
		return status;
	}
    
    public static Book getBookById(String id){
    	for(Book b:list)
			if (b.getId().equals(id))
				return b;
    	return null;
	}
    
    public static List<Book> getAllBooks() {
		return list;
	}
    
}
