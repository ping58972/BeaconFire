package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.hibernate.AddressHibernate;
import com.beaconfire.quizonline.domain.hibernate.UserHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.List;

@Repository("userDaoHibernateImpl")

public class UserDaoHibernateImpl extends AbstractHibernateDao<UserHibernate> implements UserDao {
    public UserDaoHibernateImpl() {
        setClazz(UserHibernate.class);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM UserHibernate ");
        List<User> qhList = query.list();
        System.out.println(qhList);
        return qhList;
    }

    @Override
    @Transactional
    public UserHibernate getUserById(Integer id) {
        UserHibernate user = this.findById(id);
        user.setAddressId(user.getAddress().getAddressId());
        user.setAddressToUser(user.getAddress());
        return user;
    }

    @Override
    @Transactional
    public UserHibernate getUserByEmail(String email) {
        Query query = getCurrentSession().createQuery(
                "FROM UserHibernate u WHERE u.email = :email ");
        query.setParameter("email", email);
        List<UserHibernate> list = query.list();
        if (list.size() == 0) {
            return new UserHibernate();
        }
        UserHibernate user = list.get(0);
        user.setAddressToUser(user.getAddress());
        return user;
    }

    @Override
    @Transactional
    public User createNewUser(String firstName, String lastName, String email,
                              String password, String phone, String street, String city,
                              String state, int zipcode, String country) {
        Session session = getCurrentSession();
//        AddressHibernate address = new AddressHibernate();
//        address.setStreet(street);
//        address.setCity(city);
//        address.setCountry(country);
//        address.setZipcode(zipcode);
//        address.setState(state);
//        AddressHibernate newAdd = (AddressHibernate) session.merge(address);
//        UserHibernate user = new UserHibernate();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setPhone(phone);
//        user.setAddressId(newAdd.getAddressId());
//        user.setAddress(newAdd);
//        User newUser = (User) session.merge(user);
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();

        AddressHibernate address = AddressHibernate.builder().state(state)
                .street(street).country(country).city(city).zipcode(zipcode).build();
        int newAddId = (int) session.save(address);
        System.out.println("begin new address: " + address);
        UserHibernate user = UserHibernate.builder().firstName(firstName)
                .lastName(lastName).email(email).password(password).phone(phone).address(address).isActive(true).build();
        user.setAddressId(newAddId);
        System.out.println("begin new User: " + user);
        session.saveOrUpdate(user);
        System.out.println("after new address: " + address);

        System.out.println("after new User: " + user);
        return user;
    }

    @Override
    @Transactional
    public int deleteUserById(Integer id) {
        Session session = getCurrentSession();
        UserHibernate user = session.get(UserHibernate.class, id);
        session.delete(user);
        return 1;
    }

    @Override
    @Transactional
    public int deleteUserByEmail(String email) {
        Session session = getCurrentSession();
        UserHibernate user = getUserByEmail(email);
        session.delete(user);
        return 1;
    }

    @Override
    @Transactional
    public User updateUser(Integer id, String firstName, String lastName,
                           String email, String password, boolean isActive,
                           String phone, String street, String city, String state,
                           int zipcode, String country) {
        Session session = getCurrentSession();

        UserHibernate user = session.get(UserHibernate.class, id);
        AddressHibernate address = user.getAddress();
        address.setStreet(street);
        address.setCity(city);
        address.setCountry(country);
        address.setZipcode(zipcode);
        address.setState(state);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        UserHibernate newUser = (UserHibernate) session.merge(user);
        newUser.setAddressToUser(newUser.getAddress());

        return newUser;
    }

    @Override
    @Transactional
    public int changeActiveById(int id) {
        Session session = getCurrentSession();
        UserHibernate user = session.get(UserHibernate.class, id);
        boolean active = user.isActive();
        user.setActive(!active);
        session.saveOrUpdate(user);
        return 1;
    }

    @Override
    @Transactional
    public Address getAddressById(Integer id) {
        Query query = getCurrentSession().createQuery(
                "FROM AddressHibernate add WHERE add.addressId = :id ");
        query.setParameter("id", id);
        List list = query.list();
        return (Address) list.get(0);
    }
}
