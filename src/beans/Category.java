package beans;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "beans.Category")
@Table(name = "category", catalog = "bookmanagement")
public class Category {

	private String _categoryId;
	private String _categoryName;

	private Set<Book> _books = new HashSet<Book>(0);

	public Category() {

		this.set_categoryId(UUID.randomUUID().toString());
	}

	public Category(String categoryName) {
		this.set_categoryId(UUID.randomUUID().toString());
		this.set_categoryName(categoryName);
	}

	@Id
	@GeneratedValue(generator = "uuid")
 	@GenericGenerator(name = "uuid", strategy = "uuid2")
  	@Column(name = "category_id", length = 36, unique = true, nullable = false)
	public String get_categoryId() {
		return _categoryId;
	}

	public void set_categoryId(String _categoryId) {
		this._categoryId = _categoryId;
	}

	@Column(name = "category_name", length = 50, nullable = false)
	public String get_categoryName() {
		return _categoryName;
	}

	public void set_categoryName(String _categoryName) {
		this._categoryName = _categoryName;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "_bookCategories")
	public Set<Book> get_books() {
		return _books;
	}

	public void set_books(Set<Book> _books) {
		this._books = _books;
	}

}