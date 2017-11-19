package crwm.site.dao.impl;

import crwm.site.dao.SequenceDAO;
import crwm.site.pojo.Sequence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDAOImpl extends BaseDAOImpl<Sequence> implements SequenceDAO {
    @Override
    public long getNum() {
        SessionFactory sessionFactory = super.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        NativeQuery query = session.createNativeQuery("replace into t_Sequence(stub) VALUES ('b')");
        query.executeUpdate();
        Query query1 = session.createQuery("select s.id from Sequence s where s.stub = 'b'");
        return (long) query1.uniqueResult();
    }
}
