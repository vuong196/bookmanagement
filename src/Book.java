import java.util.UUID;

public class Book {
	private String id;
	private String name;
	private String author;
	
	public Book() {
	}
	
	public Book(String name, String author) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}


}