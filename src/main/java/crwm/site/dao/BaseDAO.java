package crwm.site.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by makese on 2017/10/10.
 */
public interface BaseDAO<T> {
    T get(Serializable id);
    Serializable add(T t);
    void update(T t);
    void delete(T t);
    List<T> getList();
}
