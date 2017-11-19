import crwm.site.biz.*;
import crwm.site.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by makese on 2017/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class AddData {

    @Resource
    private UserBiz userBiz;
    @Resource
    private AdminBiz adminBiz;

    @Resource
    private ShopBiz shopBiz;

    @Resource
    private ShopTypeBiz shopTypeBiz;

    @Resource
    private ShopAptitudeBiz shopAptitudeBiz;

    @Resource
    private ReportBiz reportBiz;
    @Resource
    private SequenceBiz sequenceBiz;

    @Test()
    public void addUser(){
        User user = new User("123","123","1388888888");
        UserInfo userInfo = new UserInfo("周大嘴","周旺轩",100,"");
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        userBiz.addUser(user);

        user = userBiz.getUser(user);
        user.setPwd("1234");
        userBiz.updateUser(user);
    }

    @Test
    public void addAdmin(){
        Admin admin = new Admin("123","123","周周他父亲");
        adminBiz.addAdmin(admin);
    }

    @Test
    public void addShop(){
        List<ShopType> shopTypeList = new ArrayList<>();
        shopTypeList.add(new ShopType("美食"));
        shopTypeList.add(new ShopType("快餐便当"));
        shopTypeList.add(new ShopType("特色菜系"));
        shopTypeList.add(new ShopType("异国料理"));
        shopTypeList.add(new ShopType("小吃夜宵"));
        shopTypeList.add(new ShopType("甜品饮料"));
        shopTypeList.add(new ShopType("果蔬生鲜"));
        shopTypeList.add(new ShopType("商店超市"));
        shopTypeList.add(new ShopType("浪漫鲜花"));
        shopTypeList.add(new ShopType("理疗健康"));
        for(ShopType shopType : shopTypeList){
            shopTypeBiz.addShopType(shopType);
        }
        ShopAptitude shopAptitude = new ShopAptitude("/shopImgs/test/1.png","/shopImgs/test/2.png","/shopImgs/test/3.png","/shopImgs/test/4.png","/shopImgs/test/5.png");
        ShopInfo shopInfo = new ShopInfo("大嘴周周快餐","东北石油大学启智4b118李阳他兄弟对床","我大嘴周第一个不服");
        Shop shop = new Shop("123","123","15214568854",false,"");
        shop.setShopType(shopTypeList.get(1));
        shop.setShopInfo(shopInfo);
        shop.setShopAptitude(shopAptitude);
        shopAptitude.setShop(shop);
        shopInfo.setShop(shop);
        User user = new User("123","123","1388888888");
        UserInfo userInfo = new UserInfo("周大嘴","周旺轩",100,"");
        user.setUserInfo(userInfo);
        userInfo.setUser(user);
        userBiz.addUser(user);
        Report report = new Report(shop,"sdfsf",false);
        report.setUser(user);
        Set<Report> reportSet = new HashSet<>();
        reportSet.add(report);
        shop.setReportSet(reportSet);
        shopBiz.addShop(shop);
    }
    @Test
    @Transactional
    public void Test1(){
        Shop shop = shopBiz.getShop(1);
        System.out.printf(shop.getShopAptitude().getBusinessLicenseImg());
    }
    @Test
    @Transactional
    public void Test2(){
        Shop shop = shopBiz.getShop(1);
        Report report = new Report(shop,"sfsdfsdfds",false);
        User user = new User("21312fd","2312","1545789798465");
        report.setUser(user);
        reportBiz.addReport(report);
    }

    @Test
    public void Test3(){
        for(int i = 0; i < 1000; i ++){
            System.out.printf(sequenceBiz.getNum() + "");
        }
    }
}
