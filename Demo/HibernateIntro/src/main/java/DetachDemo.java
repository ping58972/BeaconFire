import domain.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class DetachDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();

            Bank oliverBank = session.get(Bank.class, 1);
            Bank tracyBank = session.get(Bank.class, 2);

            // evict()
//            session.evict(oliverBank);
//            oliverBank.setBalance(10000);
//            tracyBank.setBalance(0);

            // clear()
//            session.clear();
//            oliverBank.setBalance(10000);
//            tracyBank.setBalance(50);

            // flush()
            for (int i = 0; i < 99999; i++){

                if (i % 1000 == 0){
                    session.flush();
                    session.clear();
                }

                Bank newBank = Bank.builder()
                        .accountName("hello")
                        .balance(20)
                        .build();
                session.save(newBank);
            }

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
