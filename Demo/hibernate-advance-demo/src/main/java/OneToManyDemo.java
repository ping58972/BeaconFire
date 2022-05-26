import config.HibernateConfigUtil;
import domain.Choice;
import domain.Question;
import org.hibernate.*;

public class OneToManyDemo {

    public static void main(String[] args) {
//        tryInsert();
        tryGet();
    }

    static void tryInsert() {
        try (Session session = HibernateConfigUtil.openSession()) {
            Transaction transaction = null;
            transaction = session.beginTransaction();

            Question question = new Question();
            question.setQuestion("What is 1 + 1");

            Choice choice1 = new Choice();
            choice1.setChoice("1");

            Choice choice2 = new Choice();
            choice2.setChoice("2");

            Choice choice3 = new Choice();
            choice3.setChoice("3");

            Choice choice4 = new Choice();
            choice4.setChoice("4");

            question.addChoice(choice1);
            question.addChoice(choice2);
            question.addChoice(choice3);
            question.addChoice(choice4);

            System.out.println(question);

            session.saveOrUpdate(question);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void tryGet() {
        Question question = null;
        try (Session session = HibernateConfigUtil.openSession()) {
//            Transaction transaction = null;
//            transaction = session.beginTransaction();
            question = session.get(Question.class, 23);
//            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // print out question with its choices
        if (question != null) {
            System.out.println(question);
            for(Choice c : question.getChoices()) {
                System.out.println(c);
            }
        } else {
            System.out.println("question is null");
        }
    }
}

