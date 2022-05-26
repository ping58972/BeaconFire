import domain.Contact;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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
//            Contact contact1 = Contact.builder().firstName("FirstName").lastName("LastName").subject("Subject1")
//                    .message("Message").build();

//            session.update(contact1);
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//            criteriaQuery.from(User.class);
//            List<User> users =  session.createQuery(criteriaQuery).getResultList();
//            System.out.println(users);
//            users.stream().forEach(System.out::println);
            Query query = session.createQuery(
                    "FROM User WHERE email = :email ");
            query.setParameter("email", "admin@quiz.com");
            List<User> list = query.list();
            System.out.println(list.get(0));
            transaction.commit();




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
