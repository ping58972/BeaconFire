import config.HibernateConfigUtil;
import domain.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HqlDemo {

    public static void main(String[] args) {
        List<Question> questions = null;

        try (Session session = HibernateConfigUtil.openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            // Note: "fetch" eagerly loads the item now instead of lazily loading it
            Query<Question> query = session.createQuery(
                    "from Question question join fetch question.choices choices",
                    Question.class);
            questions = query.list();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(questions);
    }

}
