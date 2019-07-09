
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	private static List<Book> bookRepository = new ArrayList<Book>() {

		{

			 add(new Book("The Maze Runner", "James Dashner"));
			 add(new Book("The Hunger Game", "Suzanne Collins"));
			 add(new Book("Divergent", "Veronica Roth"));
		 }
	};

	 public static int save(Book book) {

		int status = 0;
		bookRepository.add(book);
		status = 1;
		return status;
	}

	public static int update(Book book) {

		int status = 0;
		for(Book b : bookRepository) {

			if (book.getId().equals(b.getId())) {

				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
				status = 1;
				return status;
			}
		}
		return status;
	}

	public static int delete(String id) {

		int status = 0;

		for (int i = 0; i< bookRepository.size(); i++) {

			if (bookRepository.get(i).getId().equals(id)) {

				bookRepository.remove(i);
				status = 1;
				return status;
			}
		}
		return status;
	}

	public static Book getBookById(String id) {

		for(Book b : bookRepository) {

			if (b.getId().equals(id)) {

				return b;
			}

		}
		return null;
	}

	public static List<Book> getAllBooks() {

		return bookRepository;
	}

}
