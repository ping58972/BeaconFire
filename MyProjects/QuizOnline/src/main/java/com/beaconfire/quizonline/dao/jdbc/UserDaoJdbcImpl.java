package com.beaconfire.quizonline.dao.jdbc;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.AddressRowMapper;
import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.UserRowMapper;
import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.jdbc.AddressJdbc;
import com.beaconfire.quizonline.domain.jdbc.UserJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {
    JdbcTemplate jdbcTemplate;
    UserRowMapper userRowMapper;
    AddressRowMapper addressRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setUserRowMapper(UserRowMapper userRowMapper) {
        this.userRowMapper = userRowMapper;
    }

    @Autowired
    public void setAddressRowMapper(AddressRowMapper addressRowMapper) {
        this.addressRowMapper = addressRowMapper;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM User";
        List<User> users = jdbcTemplate.query(query, userRowMapper);
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        String query = "SELECT * FROM User WHERE user_id = :identity";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("identity", id);
        List<User> users = namedParameterJdbcTemplate.query(query, parameterSource, userRowMapper);
        if (users.size() == 0) {
            User invalidUser = new UserJdbc();
            invalidUser.setUserId(-1);
            invalidUser.setMessage("Unknown User ID!");
            return invalidUser;
        }
        User user = users.get(0);
        Address address = getAddressById(user.getAddressId());
        user.setAddressToUser(address);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM User WHERE email = ?";
        List<User> users = jdbcTemplate.query(query, userRowMapper, email);
        if (users.size() == 0) {
            User invalidUser = new UserJdbc();
            invalidUser.setUserId(-1);
            invalidUser.setMessage("Unknown Email!");
            return invalidUser;
        }
        User user = users.get(0);
        Address address = getAddressById(user.getAddressId());
        user.setAddressToUser(address);
        return user;
    }

    @Override
    public User createNewUser(String firstName, String lastName, String email, String password, String phone
            , String street, String city, String state, int zipcode, String country) {
        User testUser = this.getUserByEmail(email);
        int resultNum = 0;
        if (testUser.getUserId() > 0) {
            testUser = new UserJdbc();
            testUser.setUserId(-1);
            testUser.setMessage("Email Already Exist!");
            return testUser;
        } else if (testUser.getUserId() < 1) {
            String addressQuery = "INSERT INTO Address (street, city, state, zipcode, country) VALUES " +
                    "(?, ?, ?, ?, ?)";
            int addressId = jdbcTemplate.update(addressQuery, street, city, state, zipcode, country);
            String query = "INSERT INTO User (firstname, lastname, email, password, phone, address_id)"
                    + "values(?, ?, ?, ?, ?, ?)";
            resultNum = jdbcTemplate.update(query, firstName, lastName, email, password, phone, addressId);

        }
        if (resultNum == 1) {
            return this.getUserByEmail(email);
        }
        User invalidUser = new UserJdbc();
        invalidUser.setUserId(-1);
        invalidUser.setMessage("Something Wrong!");
        return invalidUser;
    }

    @Override
    public int deleteUserById(Integer id) {
        String query = "DELETE FROM User WHERE user_id = ?";
        return jdbcTemplate.update(query, id);
    }

    @Override
    public int deleteUserByEmail(String email) {
        String query = "DELETE FROM User WHERE email = ?";
        return jdbcTemplate.update(query, email);
    }

    @Override
    public User updateUser(Integer id, String firstName, String lastName, String email, String password,
                           boolean isActive, String phone
            , String street, String city, String state, int zipcode, String country) {
        User testUser = getUserById(id);
        if (testUser.getUserId() < 1) {
            return testUser;
        }
        String addressQuery = "UPDATE Address SET street=?, city=?, state=?, zipcode=?, country=? WHERE address_id=?";
        jdbcTemplate.update(addressQuery, street, city, state, zipcode, country, testUser.getAddressId());
        String query = "UPDATE User SET firstname=?, lastname=?, email=?, password=?, is_active=? , phone=? WHERE user_id=?";
        jdbcTemplate.update(query, firstName, lastName, email, password, isActive, phone, id);
        return getUserById(id);
    }

    @Override
    public int changeActiveById(int id) {
        User user = getUserById(id);
        String query = "UPDATE User SET is_active=? WHERE user_id=?";
        return jdbcTemplate.update(query, !user.isActive(), id);
    }

    @Override
    public Address getAddressById(Integer id) {
        String query = "SELECT * FROM Address WHERE address_id = :identity";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("identity", id);
        List<Address> addresses = namedParameterJdbcTemplate.query(query, parameterSource, addressRowMapper);
        Address invalidAddress = new AddressJdbc();
        invalidAddress.setAddressId(-1);
        invalidAddress.setMessage("Unknown Address ID!");
        return addresses.size() == 0 ? invalidAddress : addresses.get(0);
    }


}

