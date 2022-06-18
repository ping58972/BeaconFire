package com.beaconfire.quizonline.dao.jdbc.rowmapper;

import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.jdbc.AddressJdbc;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new AddressJdbc();
        address.setAddressId(rs.getInt("address_id"));
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        address.setState(rs.getString("state"));
        address.setZipcode(rs.getInt("zipcode"));
        address.setCountry(rs.getString("country"));
        return address;
    }
}
