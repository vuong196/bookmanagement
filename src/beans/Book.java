
package beans;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "beans.Book")
@Table(name = "book", catalog = "bookmanagement")
public class Book {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "book_id", length = 36, unique = true, nullable = false)
	private String	_bookId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author	_bookAuthor;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "book_category", catalog = "bookmanagement", joinColumns = {
		@JoinColumn(name = "book_id", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "category_id", nullable = false, updatable = false) })
	private Set<Category>	_bookCategorySet	= new HashSet<>(0);
	
	@Column(name = "book_name", length = 50, nullable = false)
	private String	_bookName;

	public Book() {

	}

	public Book(String name, Set<Category> categories, Author author) {

		this.setBookId(UUID.randomUUID().toString());
		this.setBookAuthor(author);
		this.setBookCategorySet(categories);
		this.setBookName(name);
	}


	public Author getBookAuthor() {

		return _bookAuthor;
	}

	public Set<Category> getBookCategorySet() {

		return _bookCategorySet;
	}

	public String getBookId() {

		return _bookId;
	}

	public String getBookName() {

		return _bookName;
	}

	public void setBookAuthor(Author bookAuthor) {

		this._bookAuthor = bookAuthor;
	}

	public void setBookCategorySet(Set<Category> bookCategorySet) {

		this._bookCategorySet = bookCategorySet;
	}

	public void setBookId(String bookId) {

		this._bookId = bookId;
	}

	public void setBookName(String bookName) {

		this._bookName = bookName;
	}
}