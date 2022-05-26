import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

public class SessionDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        Session session1 = sessionFactory.openSession();
//        Session session2 = sessionFactory.openSession();
//        System.out.println(session1 == session2);

        Session session3 = sessionFactory.getCurrentSession();
        Session session4 = sessionFactory.getCurrentSession();

        System.out.println(session3 == session4);

        HibernateUtil.closeSessionFactory();
    }

}
