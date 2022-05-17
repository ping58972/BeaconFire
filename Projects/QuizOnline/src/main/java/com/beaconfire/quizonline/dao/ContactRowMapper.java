package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Contact;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setContactId(rs.getInt("contact_id"));
        contact.setFirstName(rs.getString("firstname"));
        contact.setLastName(rs.getString("lastname"));
        contact.setSubject(rs.getString("subject"));
        contact.setMessage(rs.getString("message"));
        return contact;
    }
}
