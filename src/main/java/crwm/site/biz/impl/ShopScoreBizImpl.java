package crwm.site.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import crwm.site.biz.ShopScoreBiz;
import crwm.site.dao.ShopScoreDAO;
import crwm.site.pojo.ShopScore;
@Service
public class ShopScoreBizImpl implements ShopScoreBiz {
	@Resource
	private ShopScoreDAO shopScoreDAO;

	@Override
	public void add(ShopScore shopScore) {
		shopScoreDAO.add(shopScore);
		
	}
	

}
