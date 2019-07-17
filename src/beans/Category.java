
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

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "_bookCategorySet")
	private Set<Book> _categoryBookSet = new HashSet<>(0);

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "category_id", length = 36, unique = true, nullable = false)
	private String _categoryId;

	@Column(name = "category_name", length = 50, nullable = false)
	private String _categoryName;

	public Category() {

		_categoryId = UUID.randomUUID().toString();
	}

	public Category(String categoryName) {

		_categoryId = UUID.randomUUID().toString();
		_categoryName = categoryName;
	}

	public Set<Book> getCategoryBookSet() {

		return _categoryBookSet;
	}

	public String getCategoryId() {

		return _categoryId;
	}

	public String getCategoryName() {

		return _categoryName;
	}

	public void setCategoryBookSet(Set<Book> categoryBookSet) {

		this._categoryBookSet = categoryBookSet;
	}

	public void setCategoryId(String categoryId) {

		this._categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {

		this._categoryName = categoryName;
	}
}