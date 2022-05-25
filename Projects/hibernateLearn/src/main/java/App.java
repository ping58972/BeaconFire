import domain.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
//        boolean falseworkFlow = false;
        try{
            transaction = session.beginTransaction();
            Contact contact1 = Contact.builder().firstName("FirstName").lastName("LastName").subject("Subject1")
                    .message("Message").build();

            session.update(contact1);
//            transaction.commit();
            System.out.println(contact1);


        } catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
    }
}
