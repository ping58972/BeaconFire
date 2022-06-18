package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.ContactRowMapper;
import com.beaconfire.quizonline.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ContactDao {

    List<Contact> getAllContact();

    Optional<Contact> getContactById(int id);

    int createNewContact(String firstName, String lastName, String subject, String message);

    int updateContact(int id, String firstName, String lastName, String subject, String message);

    int deleteContactById(int id);

}
