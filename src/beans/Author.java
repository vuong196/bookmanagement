
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

	private Set<Book>	_authorBookSet	= new HashSet<>(0);
	private String	_authorId;
	private String	_authorName;

	public Author() {

		this.setAuthorId(UUID.randomUUID().toString());
	}

	public Author(String authorName) {

		this.setAuthorId(UUID.randomUUID().toString());
		this.setAuthorName(authorName);
	}

	public Author(String authorName, Set<Book> bookSet) {

		this.setAuthorId(UUID.randomUUID().toString());
		this.setAuthorName(authorName);
		this.setBooks(bookSet);
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "author_id", length = 36, unique = true, nullable = false)
	public String getAuthorId() {

		return _authorId;
	}

	@Column(name = "author_name", length = 50, nullable = false)
	public String getAuthorName() {

		return _authorName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_bookAuthor")
	public Set<Book> getBooks() {

		return _authorBookSet;
	}

	public void setAuthorId(String authorId) {

		this._authorId = authorId;
	}

	public void setAuthorName(String authorName) {

		this._authorName = authorName;
	}

	public void setBooks(Set<Book> bookSet) {

		this._authorBookSet = bookSet;
	}
}