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

	private String _bookId;

	private String _bookName;

	private Author _bookAuthor;

	private Set<Category> _bookCategories = new HashSet<Category>(0);

	public Book() {

	}

	public Book(String name, Set<Category> categories, Author author) {

		this.set_bookId(UUID.randomUUID().toString());
		this.set_bookName(name);
		this.set_bookCategories(categories);
		this.set_bookAuthor(author);
	}

	@Id
	@GeneratedValue(generator = "uuid")
 	@GenericGenerator(name = "uuid", strategy = "uuid2")
  	@Column(name = "book_id", length = 36, unique = true, nullable = false)
	public String get_bookId() {
		return _bookId;
	}

	public void set_bookId(String _bookId) {
		this._bookId = _bookId;
	}

	@Column(name = "book_name", length = 50, nullable = false)
	public String get_bookName() {
		return _bookName;
	}

	public void set_bookName(String _bookName) {
		this._bookName = _bookName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "author_id", nullable = false)
	public Author get_bookAuthor() {
		return _bookAuthor;
	}

	public void set_bookAuthor(Author _bookAuthor) {
		this._bookAuthor = _bookAuthor;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "book_category",catalog = "bookmanagement", joinColumns = {
		@JoinColumn(name = "book_id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "category_id",
			nullable = false, updatable = false) })
	public Set<Category> get_bookCategories() {
		return _bookCategories;
	}

	public void set_bookCategories(Set<Category> _bookCategories) {
		this._bookCategories = _bookCategories;
	}
}