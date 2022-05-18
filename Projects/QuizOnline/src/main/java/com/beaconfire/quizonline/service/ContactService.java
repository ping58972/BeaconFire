package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.ContactDao;
import com.beaconfire.quizonline.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactDao contactDao;

    @Autowired
    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> getAllContact() {
        return contactDao.getAllContact();
    }

    public boolean createNewContactMessage(Contact contact) {
        return 1 == contactDao.createNewContact(contact.getFirstName(),
                contact.getLastName(), contact.getSubject(), contact.getMessage());
    }
}
