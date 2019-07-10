package daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Book;
import beans.Category;
import beans.Author;
import configurations.HibernateUtils;

public class BookDAO {

	 public static boolean save(String name, String category_id, String author_id) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {
			Author author = session.get(Author.class, author_id);
			Set<Category> categories = new HashSet<Category>();
			categories.add(session.get(Category.class, category_id));

			Book newBook = new Book(name, categories, author);
			session.save(newBook);
			transaction.commit();
		}
		catch(Exception e)	{

			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();

		return status;
	}

	public static boolean update(String id, String name, String category_id, String author_id) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		try {

			Author author = session.get(Author.class, author_id);
			Set<Category> categories = new HashSet<Category>();
			categories.add(session.get(Category.class, category_id));

			Book book = new Book();
			book.set_bookName(name);
			book.set_bookAuthor(author);
			book.set_bookCategories(categories);

			session.update(book);
			transaction.commit();
		}
		catch(Exception e)	{

			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();

		return status;
	}

	public static boolean delete(String id) {

		boolean status = true;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {

			Book deleteBook = session.get(Book.class, id);
			session.delete(deleteBook);
			transaction.commit();
		}
		catch(Exception e)	{

			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
			status = false;
		}
		session.close();

		return status;
	}

	public static Book getBookById(String id) {

		Book book = new Book();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {

			book = session.get(Book.class, id);
			transaction.commit();
		}
		catch(Exception e)	{

			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}
		session.close();

		return book;
	}

	public static List<Book> getAllBooks() {
		List<Book> bookRepository = new ArrayList<Book>();
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Book> query = session.createQuery("FROM " + Book.class.getName());
			System.out.println(query);
			bookRepository = (ArrayList<Book>) query.list();
			transaction.commit();
			} catch (Exception e) {

				e.printStackTrace();
				// Rollback trong trường hợp có lỗi xẩy ra.
				transaction.rollback();
			}

		session.close();
		return bookRepository;
	}

}
