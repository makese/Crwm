package crwm.site.biz.impl;

import crwm.site.biz.FoodScoreBiz;
import crwm.site.dao.FoodScoreDAO;
import crwm.site.pojo.FoodScore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodScoreBizImpl implements FoodScoreBiz {

    @Resource
    FoodScoreDAO foodScoreDAO;

    @Override
    public List<FoodScore> getAllFoodScoreList() {
        return foodScoreDAO.getList();
    }
}
