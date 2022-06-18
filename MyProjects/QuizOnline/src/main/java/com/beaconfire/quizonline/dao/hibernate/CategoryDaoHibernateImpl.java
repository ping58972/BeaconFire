package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.CategoryDao;
import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.hibernate.CategoryHibernate;
import com.beaconfire.quizonline.domain.hibernate.UserHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("categoryDaoHibernateImpl")
@Transactional
public class CategoryDaoHibernateImpl extends AbstractHibernateDao<CategoryHibernate> implements CategoryDao {

    public CategoryDaoHibernateImpl() {
        setClazz(CategoryHibernate.class);
    }

    @Override
    public List<Category> getAllCategory() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM CategoryHibernate ");
        List<Category> qhList = query.list();
        System.out.println(qhList);
        return qhList;
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        CategoryHibernate cat = findById(id);
        return Optional.of(cat);
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        Query query = getCurrentSession().createQuery(
                "FROM CategoryHibernate c WHERE c.name = :name ");
        query.setParameter("name", name);
        List<CategoryHibernate> list = query.list();
        if (list.size() == 0) {
            return Optional.of(new CategoryHibernate());
        }
        return Optional.of(list.get(0));
    }

    @Override
    public int createNewCategory(String name, String imageUrl) {
        return 0;
    }

    @Override
    public int updateCategory(int id, String name, String imageUrl) {
        return 0;
    }

    @Override
    public int deleteCategoryById(Integer id) {
        return 0;
    }
}
