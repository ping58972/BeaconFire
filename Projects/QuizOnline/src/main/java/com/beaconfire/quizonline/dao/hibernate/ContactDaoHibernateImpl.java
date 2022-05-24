package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.ContactDao;
import com.beaconfire.quizonline.dao.QuizQuestionDao;
import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.Contact;
import com.beaconfire.quizonline.domain.hibernate.ContactHibernate;
import com.beaconfire.quizonline.domain.hibernate.QuizQuestionHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("contactDaoHibernateImpl")
@Transactional
public class ContactDaoHibernateImpl extends AbstractHibernateDao<ContactHibernate> implements ContactDao {

    @Override
    public List<Contact> getAllContact() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM ContactHibernate ");
        List<Contact> qhList = query.list();
        return qhList;
    }

    @Override
    public Optional<Contact> getContactById(int id) {
        ContactHibernate cont = findById(id);
        return Optional.of(cont);
    }

    @Override
    public int createNewContact(String firstName, String lastName, String subject,
                                String message) {
        ContactHibernate cont = new ContactHibernate();
        cont.setFirstName(firstName);
        cont.setLastName(lastName);
        cont.setSubject(subject);
        cont.setMessage(message);
        return (int) getCurrentSession().save(cont);
    }

    @Override
    public int updateContact(int id, String firstName, String lastName,
                             String subject, String message) {
        ContactHibernate cont = findById(id);
        cont.setFirstName(firstName);
        cont.setLastName(lastName);
        cont.setSubject(subject);
        cont.setMessage(message);
        return (int) getCurrentSession().save(cont);
    }

    @Override
    public int deleteContactById(int id) {
        ContactHibernate cont = findById(id);
        getCurrentSession().delete(cont);
        return 1;
    }
}
