package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.UserDao;
import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("userDaoHibernateImpl")
public class UserDaoHibernateImpl extends AbstractHibernateDao<UserHibernate> implements UserDao {

    public UserDaoHibernateImpl() {
        setClazz(UserHibernate.class);
    }

    @Override
    public List<User> getAllUsers() {
        return  getAll().stream().map(u->(User)u).collect(Collectors.toList());

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User createNewUser(User user) {
        return null;
    }

    @Override
    public User deleteUserById(int id) {
        return null;
    }

    @Override
    public User changeUserStatus(int id, boolean activate) {
        return null;
    }


}
