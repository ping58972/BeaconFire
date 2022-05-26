package dao;

import config.HibernateConfigUtil;
import domain.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDao {

    public Category getCategoryById(Integer id) {
        Session session = null;
        Transaction transaction = null;
        Category category = null;

        try {
            session = HibernateConfigUtil.openSession();
            transaction = session.beginTransaction();

            category = session.get(Category.class, id);
            System.out.println(category.getName());

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }
}
