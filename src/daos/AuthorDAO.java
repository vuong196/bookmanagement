
package daos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import beans.Author;
import configurations.HibernateUtils;
public class AuthorDAO {

	public static boolean delete(String id) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Author deleteAuthor = session.get(Author.class, id);
			session.delete(deleteAuthor);
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

	public static List<Author> getAllAuthors() {

		List<Author> authorRepository = new ArrayList<>();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Author> query = session.createQuery("FROM " + Author.class.getName());
			System.out.println(query);
			authorRepository = query.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			transaction.rollback();
		}
		session.close();
		return authorRepository;
	}

	public static Author getAuthorById(String author_id) {

		Author author = new Author();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			author = session.get(Author.class, author_id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}
		session.close();
		return author;
	}

	public static boolean save(String name) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Author newAuthor = new Author(name);
			session.save(newAuthor);
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
		Author Author = new Author();
		Author.setAuthorId(id);
		Author.setAuthorName(name);
		try {
			session.update(Author);
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
