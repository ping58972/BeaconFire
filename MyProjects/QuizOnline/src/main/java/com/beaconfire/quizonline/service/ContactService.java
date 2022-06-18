package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.ContactDao;
import com.beaconfire.quizonline.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private ContactDao contactDaoJdbc;
    private ContactDao contactDaoHibernate;

    @Autowired
    @Qualifier("contactDaoJdbcImpl")
    public void setContactDaoJdbc(ContactDao contactDaoJdbc) {
        this.contactDaoJdbc = contactDaoJdbc;
    }

    @Autowired
    @Qualifier("contactDaoHibernateImpl")
    public void setContactDaoHibernate(ContactDao contactDaoHibernate) {
        this.contactDaoHibernate = contactDaoHibernate;
    }


    public List<Contact> getAllContact() {

        return contactDaoHibernate.getAllContact();
//        return contactDaoJdbc.getAllContact();
    }

    public boolean createNewContactMessage(Contact contact) {
//        return 1 == contactDaoJdbc.createNewContact(contact.getFirstName(),
//                contact.getLastName(), contact.getSubject(), contact.getMessage());
        return 0 < contactDaoHibernate.createNewContact(contact.getFirstName(),
                contact.getLastName(), contact.getSubject(), contact.getMessage());
    }
}
