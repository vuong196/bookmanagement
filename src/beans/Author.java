
package beans;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "beans.Author")
@Table(name = "author", catalog = "bookmanagement")
public class Author {

	private String		_authorId;
	private String		_authorName;
	private Set<Book>	_books	= new HashSet<>(0);

	public Author() {

		this.set_authorId(UUID.randomUUID().toString());
	}

	public Author(String authorName) {

		this.set_authorId(UUID.randomUUID().toString());
		this.set_authorName(authorName);
	}

	public Author(String authorName, Set<Book> books) {

		this.set_authorId(UUID.randomUUID().toString());
		this.set_authorName(authorName);
		this.set_books(books);
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "author_id", length = 36, unique = true, nullable = false)
	public String get_authorId() {

		return _authorId;
	}

	@Column(name = "author_name", length = 50, nullable = false)
	public String get_authorName() {

		return _authorName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_bookAuthor")
	public Set<Book> get_books() {

		return _books;
	}

	public void set_authorId(String _authorId) {

		this._authorId = _authorId;
	}

	public void set_authorName(String _authorName) {

		this._authorName = _authorName;
	}

	public void set_books(Set<Book> _books) {

		this._books = _books;
	}
}