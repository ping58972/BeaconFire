package com.beaconfire.quizonline.dao.jdbc;

import com.beaconfire.quizonline.dao.ContactDao;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.ContactRowMapper;
import com.beaconfire.quizonline.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContactDaoJdbcImpl implements ContactDao {

    JdbcTemplate jdbcTemplate;
    ContactRowMapper contactRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setContactRowMapper(ContactRowMapper contactRowMapper) {
        this.contactRowMapper = contactRowMapper;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Contact> getAllContact() {
        return jdbcTemplate.query("SELECT * FROM Contact", contactRowMapper);
    }

    public Optional<Contact> getContactById(int id) {
        return jdbcTemplate.query("SELECT * FROM Contact WHERE contact_id=?",
                contactRowMapper, id).stream().findFirst();
    }

    public int createNewContact(String firstName, String lastName, String subject, String message) {
        String query = "INSERT INTO Contact(firstname, lastname, subject, message) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(query, firstName, lastName, subject, message);
    }

    public int updateContact(int id, String firstName, String lastName, String subject, String message) {
        String query = "UPDATE Contact SET firstname=?, lastname=?, subject=?, message=? WHERE contact_id=?";
        return jdbcTemplate.update(query, firstName, lastName, subject, message, id);
    }

    public int deleteContactById(int id) {
        return jdbcTemplate.update("DELETE FROM Contact WHERE contact_id=?", id);
    }

}
