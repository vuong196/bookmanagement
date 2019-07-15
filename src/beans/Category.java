
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

	private Set<Book>	_categoryBookSet	= new HashSet<>(0);
	private String	_categoryId;
	private String	_categoryName;

	public Category() {

		this.setCategoryId(UUID.randomUUID().toString());
	}

	public Category(String categoryName) {

		this.setCategoryId(UUID.randomUUID().toString());
		this.setCategoryName(categoryName);
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "_bookCategorySet")
	public Set<Book> getCategoryBookSet() {

		return _categoryBookSet;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "category_id", length = 36, unique = true, nullable = false)
	public String getCategoryId() {

		return _categoryId;
	}

	@Column(name = "category_name", length = 50, nullable = false)
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