package crwm.site.dao;

import crwm.site.pojo.Sequence;

public interface SequenceDAO extends BaseDAO<Sequence> {
    long getNum();
}
