package crwm.site.biz.impl;

import crwm.site.biz.SequenceBiz;
import crwm.site.dao.SequenceDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SequenceBizImpl implements SequenceBiz {

    @Resource
    private SequenceDAO sequenceDAO;

    @Override
    public long getNum() {
        return sequenceDAO.getNum();
    }
}
