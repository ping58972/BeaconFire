import domain.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class TransactionDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        boolean falseWorkFlow = false;

        try{
            transaction = session.beginTransaction();

            Bank oliverAccount = session.load(Bank.class, 1);
            Bank tracyAccount = session.load(Bank.class, 2);

            System.out.println(oliverAccount);
            System.out.println(tracyAccount);

            oliverAccount.setBalance(50);

            if (falseWorkFlow){
                throw new RuntimeException();
            } else {
                tracyAccount.setBalance(0);
            }

            session.update(oliverAccount);
            session.update(tracyAccount);

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
