package beans;

import java.util.UUID;

public class Book {

	private String _id;
	private String _name;
	private String _author;

	public Book() {

	}

	public Book(String name, String author) {

		this._id = UUID.randomUUID().toString();;
		this._name = name;
		this._author = author;
	}

	public String getId() {

		return _id;
	}

	public void setId(String id) {

		this._id = id;
	}

	public String getName() {

		return this._name;
	}

	public void setName(String name) {

		this._name = name;
	}

	public String getAuthor() {

		return this._author;
	}

	public void setAuthor(String author) {

		this._author = author;
	}


}