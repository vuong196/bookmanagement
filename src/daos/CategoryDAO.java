
package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import beans.Category;
import configurations.HibernateUtils;

public class CategoryDAO {

	public static boolean delete(String id) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Category deleteCategory = session.get(Category.class, id);
			session.delete(deleteCategory);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();
		return status;
	}

	public static List<Category> getAllCategories() {

		List<Category> categoryRepository = new ArrayList<>();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Category> query = session.createQuery("FROM " + Category.class.getName());
			System.out.println(query);
			categoryRepository = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			transaction.rollback();
		}
		session.close();
		return categoryRepository;
	}

	public static Category getCategoryById(String id) {

		Category category = new Category();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			category = session.get(Category.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}
		session.close();
		return category;
	}

	public static boolean save(String name) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Category newCategory = new Category(name);
			System.out.println(newCategory);
			session.save(newCategory);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();
		return status;
	}

	public static boolean update(String id, String name) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Category category = new Category();
		category.setCategoryId(id);
		category.setCategoryName(name);
		try {
			session.update(category);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();
		return status;
	}
}
