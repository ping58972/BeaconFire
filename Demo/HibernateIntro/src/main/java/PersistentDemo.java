import domain.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class PersistentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();


            // save()
//            Bank aprilBank = Bank.builder()
//                    .accountName("April")
//                    .balance(100)
//                    .build();
//
//            // what is the state for aprilBank? - transient
//
//            Integer id = (Integer) session.save(aprilBank);
//
//            // what is the state for aprilBank? - persistent
//
//            aprilBank.setBalance(1000);
//
//            System.out.println("April's account number is " + id);

            // persist()
//            Bank lexiBank = Bank.builder()
//                    .accountName("Lexi")
//                    .balance(200)
//                    .build();
//
//            // what is the state for lexiBank? - transient
//
//            session.persist(lexiBank);
//
//            // what is the state for lexiBank? - persistent

            // update()
            Bank oliverBank = session.get(Bank.class, 1);
            // turn oliverBank into detached state
            session.evict(oliverBank);
            // update oliverBank while in detached state - will it reflect to database?
            oliverBank.setBalance(20000);

            // will it reflect to database after using update?
            session.update(oliverBank);

            // what state would oliverBank be after using update? - persistent
            // will the changes done on oliverBank be reflected to the database?
            oliverBank.setBalance(50);

            // use update on transient object?
//            Bank daniBank = Bank.builder()
//                    .accountName("Dani")
//                    .balance(3000)
//                    .build();
//
//            session.update(daniBank);

            // merge()
//            Bank tracyBank = session.get(Bank.class, 2);
//            session.evict(tracyBank);
//            tracyBank.setBalance(5000);
//
//            Bank persistentTracyBank = (Bank) session.merge(tracyBank);
//
//            // what state would tracyBank be after using merge? - detached
//            tracyBank.setBalance(0);
//
//            // what state would persistentTracyBank be after using merge? - persistent
//            persistentTracyBank.setBalance(50);

            // saveOrUpdate()
//            Bank daniBank = Bank.builder()
//                    .accountName("Dani")
//                    .balance(3000)
//                    .build();
//
//            session.saveOrUpdate(daniBank);

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

