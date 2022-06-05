package com.beaconfire.quizauthentication.dao;

import com.beaconfire.quizauthentication.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDaoImpl")
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao{
    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public Optional<User> loadUserByEmail(String email) {
        Query query = getCurrentSession().createQuery(
                "FROM User WHERE email = :email ");
        query.setParameter("email", email);
        List<User> list = query.list();
        System.out.println(list);
        return list.stream().findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return getAll();
    }


}
