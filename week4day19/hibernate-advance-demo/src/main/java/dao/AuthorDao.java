package dao;

import javax.persistence.OptimisticLockException;

import config.HibernateConfigUtil;
import domain.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao {

    public void getOptimisticLocking() {

        Session session1 = null;
        Session session2 = null;
        Transaction txn1 = null;
        Transaction txn2 = null;

        try {
            session1 = HibernateConfigUtil.openSession();
            session2 = HibernateConfigUtil.openSession();

            txn1 = session1.beginTransaction();
            txn2 = session2.beginTransaction();

            Author author1 = session1.get(Author.class, 1);
            Author author2 = session2.get(Author.class, 1);

            author1.setFirstName("session 1");
            author2.setFirstName("session 2");

            System.out.println("=== Before txn1 commit ===");
            System.out.println("Author1: " + author1.getId() + " -- " + author1.getVersion());
            System.out.println("Author2: " + author2.getId() + " -- " + author2.getVersion());

            txn1.commit();

            System.out.println("=== After txn1 commit ===");
            System.out.println("Author1: " + author1.getId() + " -- " + author1.getVersion());
            System.out.println("Author2: " + author2.getId() + " -- " + author2.getVersion());

            txn2.commit();
        } catch (OptimisticLockException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session1 != null) {
                session1.close();
            }
            if (session2 != null) {
                session2.close();
            }
        }

    }
}
