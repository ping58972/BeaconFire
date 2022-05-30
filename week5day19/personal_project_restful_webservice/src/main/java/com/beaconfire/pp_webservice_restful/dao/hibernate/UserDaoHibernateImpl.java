package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.UserDao;
import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository("userDaoHibernateImpl")
public class UserDaoHibernateImpl extends AbstractHibernateDao<UserHibernate> implements UserDao {

    public UserDaoHibernateImpl() {
        setClazz(UserHibernate.class);
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        return getAll().stream().map(u->(User)u).collect(Collectors.toList());

    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        User user = findById(id);
        if(user == null){
            throw new UserNotFoundException("User ID Not found .");
        }
        return user;
    }

    @Override
    public User createNewUser(User user) throws UserNotFoundException {
//        this.add((UserHibernate) user);
        getCurrentSession().save((UserHibernate)user);
        System.out.println(user);
        return user;
    }

    @Override
    public User deleteUserById(int id) throws UserNotFoundException {
        Transaction transaction = null;
        UserHibernate user = null;
        try {
            transaction = getCurrentSession().beginTransaction();
            user = getCurrentSession().get(UserHibernate.class, id);
            if(user == null){
                throw new UserNotFoundException("User Not found to delete.");
            }
            transaction.commit();
            transaction = getCurrentSession().beginTransaction();
            getCurrentSession().delete(user);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();

            if(transaction != null){
                transaction.rollback();
            }
            throw new UserNotFoundException("Uh! something wrong!");
        }
        return user;
    }

    @Override
    public User changeUserStatus(int id, boolean activate) throws UserNotFoundException {
        Transaction transaction = null;
        UserHibernate user = null;
        try {
            transaction = getCurrentSession().beginTransaction();
            user = getCurrentSession().get(UserHibernate.class, id);
            transaction.commit();
            transaction = getCurrentSession().beginTransaction();
            user.setIsActive(activate);
            getCurrentSession().update(user);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
            throw new UserNotFoundException("Uh! something wrong!");
        }
        return user;
    }


}
