package crwm.site.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import crwm.site.dao.BaseDAO;

import javax.annotation.Resource;

/**
 * Created by makese on 2017/10/10.
 */
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

    private Class<T> entityClass;
    public BaseDAOImpl(){
        Type getericType = getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) getericType).getActualTypeArguments();
        entityClass = (Class<T>) actualTypeArguments[0];

    }
    @Override
    public T get(Serializable id) {
        return super.getHibernateTemplate().load(entityClass, id);
    }

    @Override
    public Serializable add(T t) {
        return super.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        super.getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        super.getHibernateTemplate().delete(t);
    }

    @Override
    public List<T> getList() {
       return super.getHibernateTemplate().loadAll(entityClass);
    }

    @Resource
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
