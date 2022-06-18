package com.beaconfire.quizrestful.dao.hibernate;

import com.beaconfire.quizrestful.dao.UserDao;
import com.beaconfire.quizrestful.domain.User;
import com.beaconfire.quizrestful.domain.hibernate.UserHibernate;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.hibernate.Transaction;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("allUser")
    public List<User> getAllUsers() throws UserNotFoundException {
        return getAll().stream().map(u->(User)u).collect(Collectors.toList());

    }
    @Override
    @Cacheable("userId")
    public User getUserById(int id) throws UserNotFoundException {
        User user = findById(id);
        if(user == null){
            throw new UserNotFoundException("User ID Not found .");
        }
        return user;
    }
    @Override
    @Transactional
    @Cacheable("userId")
    public User getUserByIdAsync(int id) throws UserNotFoundException {
        User user = findById(id);
        if(user == null){
            throw new UserNotFoundException("User ID Not found .");
        }
        return user;
//
//        Transaction transaction = null;
//        UserHibernate user = null;
//        try {
//            transaction = getCurrentSession().beginTransaction();
//            user = getCurrentSession().get(UserHibernate.class, id);
//            transaction.commit();
//            if(user == null){
//                throw new UserNotFoundException("User Not found to delete.");
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//
//            if(transaction != null){
//                transaction.rollback();
//            }
//            throw new UserNotFoundException("Uh! something wrong! <53>");
//        }
//        return user;
    }

    @Override
    @CachePut(cacheNames = "user")
    public User createNewUser(User user) throws UserNotFoundException {
//        this.add((UserHibernate) user);
        getCurrentSession().save((UserHibernate)user);
        System.out.println(user);
        return user;
    }

    @Override
    @CacheEvict(cacheNames = "allUser", allEntries = true)
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
    @CachePut(cacheNames = "userStatus", key = "#id")
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
