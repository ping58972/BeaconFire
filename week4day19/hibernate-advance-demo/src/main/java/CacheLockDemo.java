import config.HibernateConfigUtil;
import dao.AuthorDao;
import dao.CategoryDao;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class CacheLockDemo {

    public static void main(String[] args) {

        //Cache
//        CategoryDao dao = new CategoryDao();
//
//        dao.getCategoryById(1); // DB
//        dao.getCategoryById(1); // cache
//        dao.getCategoryById(2); // DB
//
//		Cache cache = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("domain.Category");
//		System.out.println("Cache Size: " + cache.getSize()); //called two methods
//		System.out.println(cache.getKeys());

        //Lock
        AuthorDao authorDao = new AuthorDao();
        authorDao.getOptimisticLocking();
        HibernateConfigUtil.getSessionFactory().close();
    }
}
