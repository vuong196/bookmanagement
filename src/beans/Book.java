package beans;

import java.util.UUID;

public class Book {

	private String _bookId;
	private String _bookName;
	private String _bookAuthor;

	public Book() {

	}

	public Book(String name, String author) {

		this.set_bookId(UUID.randomUUID().toString());;
		this.set_bookName(name);
		this.set_bookAuthor(author);
	}

	public String get_bookId() {
		return _bookId;
	}

	public void set_bookId(String _bookId) {
		this._bookId = _bookId;
	}

	public String get_bookName() {
		return _bookName;
	}

	public void set_bookName(String _bookName) {
		this._bookName = _bookName;
	}

	public String get_bookAuthor() {
		return _bookAuthor;
	}

	public void set_bookAuthor(String _bookAuthor) {
		this._bookAuthor = _bookAuthor;
	}






}