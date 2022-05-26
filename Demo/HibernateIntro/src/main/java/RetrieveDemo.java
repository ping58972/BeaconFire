import domain.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class RetrieveDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try{

            transaction = session.beginTransaction();

//            Bank bank1 = session.get(Bank.class, 3);

//            System.out.println(bank1);

            Bank bank2 = session.load(Bank.class, 2);

//            System.out.println(bank2);

            transaction.commit();

        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }

    }

}
