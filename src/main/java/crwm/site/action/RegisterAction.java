package crwm.site.action;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.ShopBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;
import crwm.site.pojo.UserInfo;
import crwm.site.util.SendMessage;
@Controller
@Scope("prototype")
public class RegisterAction  {

	
	private String tel;
	private String result;
	@Resource
	private UserBiz userBiz;
	@Resource
	private ShopBiz shopBiz;
	private User user=null;
	private Shop shop=null;
	private String verify;
	private String loginId;
	private String pwd;
	private String pwd1;
	private UserInfo userInfo;
		public String userByPhone(){
		
			try {
				String key=SendMessage.sendSms(tel);
				ActionContext.getContext().getSession().put("key", key);
			} catch (ClientException e) {
				e.printStackTrace();
			}
			Gson json=new Gson();
			result=json.toJson("ok");
			return "success";
			
		}
		public String userByPwd(){
			Gson json=new Gson();
			if(StringUtils.isEmpty(loginId)&& StringUtils.isBlank(loginId)){
				
				result=json.toJson("nologinId");
				return "wrong";
				
			}
			
			//�ж��û��Ƿ�ע���
			if(userBiz.getUserByLoginId(loginId)!=null){
				result=json.toJson("existUser");
				return "wrong";
				
			}
			//�ж������Ƿ�Ϊ��
			if(StringUtils.isEmpty(pwd)&& StringUtils.isBlank(pwd)){
				
				result=json.toJson("noPWD");
				return "wrong";
				
			}
			//�ж������ȷ�������Ƿ���ͬ
			if(!pwd.toString().equals(pwd1.toString())){
				
				result=json.toJson("difPWD");
				return "wrong";
				
			}
			if(user==null){
				user=new User();
			}
			if(userInfo==null){
				userInfo=new UserInfo();
			}
			userInfo.setHeadImg("images/head.jpg");
			userInfo.setUser(user);
			user.setLoginId(loginId);
			user.setPwd(pwd);
			user.setUserInfo(userInfo);
			userBiz.addUser(user);
			result=json.toJson("ok");
			return "success";
		}
		public String shopByPhone(){
			try {
				String key=SendMessage.sendSms(tel);
				ActionContext.getContext().getSession().put("key", key);
			} catch (ClientException e) {
				e.printStackTrace();
			}
			Gson json=new Gson();
			result=json.toJson("ok");
			return "success";



		}
		public String shopByPwd(){
			Gson json=new Gson();
			if(StringUtils.isEmpty(loginId)&& StringUtils.isBlank(loginId)){

				result=json.toJson("nologinId");
				return "wrong";

			}

			//�ж��û��Ƿ�ע���
			if(shopBiz.getShopByLoginId(loginId)!=null){
				result=json.toJson("existUser");
				return "wrong";

			}
			//�ж������Ƿ�Ϊ��
			if(StringUtils.isEmpty(pwd)&& StringUtils.isBlank(pwd)){

				result=json.toJson("noPWD");
				return "wrong";

			}
			//�ж������ȷ�������Ƿ���ͬ
			if(!pwd.toString().equals(pwd1.toString())){

				result=json.toJson("difPWD");
				return "wrong";

			}
			if(shop==null){
				shop=new Shop();
			}
			shop.setLoginId(loginId);
			shop.setPwd(pwd);
			Serializable id=shopBiz.addShop(shop);
			Shop currShop=shopBiz.getShop(id);
			ServletActionContext.getRequest().getSession().setAttribute("currShop", currShop);
			result=json.toJson("ok");
			return "success";
		}
		public String verify(){
			Gson json=new Gson();
			if(StringUtils.isEmpty(tel)&& StringUtils.isBlank(tel)){
				
				result=json.toJson("noTEL");
				return "wrong";
				
			}
			//�ж��û��Ƿ�ע���
			if(userBiz.getUser(tel)!=null){
				ServletActionContext.getRequest().getSession().removeAttribute("key");
				result=json.toJson("existUser");
				return "wrong";
				
			}
			
			
			Object keyStr=ActionContext.getContext().getSession().get("key");
			System.out.println(keyStr);
			if(keyStr!=null){//�ж��Ƿ�����֤��
			String	key=(String)keyStr;
			
				if(key.equals(verify)){//�ж���֤���Ƿ���ȷ
					if(user==null){
						user=new User();
					}
					if(userInfo==null){
						userInfo=new UserInfo();
					}
					userInfo.setHeadImg("images/head.jpg");
					userInfo.setUser(user);
					user.setTel(tel);
					user.setPwd(tel.substring(5));
					user.setUserInfo(userInfo);
					userBiz.addUser(user);
					result=json.toJson("success");
					ServletActionContext.getRequest().getSession().removeAttribute("key");
					return "success";
					
				}else{
					result=json.toJson("wrong");
					return "wrong";
					
				}
				
			}else{//��������֤��
				ServletActionContext.getRequest().getSession().removeAttribute("key");
				result=json.toJson("miss");
				return "wrong";
				
			}
			
		}
		public String verifyShop(){
			Gson json=new Gson();
			if(StringUtils.isEmpty(tel)&& StringUtils.isBlank(tel)){

				result=json.toJson("noTEL");
				return "wrong";

			}
			//�ж��û��Ƿ�ע���
			if(shopBiz.getUser(tel)!=null){
				ServletActionContext.getRequest().getSession().removeAttribute("key");
				result=json.toJson("existUser");
				return "wrong";

			}


			Object keyStr=ActionContext.getContext().getSession().get("key");
			System.out.println(keyStr);
			if(keyStr!=null){//�ж��Ƿ�����֤��
			String	key=(String)keyStr;

				if(key.equals(verify)){//�ж���֤���Ƿ���ȷ
					if(shop==null){
						shop=new Shop();
					}
					shop.setTel(tel);
					shop.setPwd(tel.substring(5));
					Serializable id=shopBiz.addShop(shop);
					Shop currShop=shopBiz.getShop(id);
					result=json.toJson("success");
					ServletActionContext.getRequest().getSession().removeAttribute("key");
					ServletActionContext.getRequest().getSession().setAttribute("currShop", currShop);
					return "success";

				}else{
					result=json.toJson("wrong");
					return "wrong";

				}

			}else{//��������֤��
				ServletActionContext.getRequest().getSession().removeAttribute("key");
				result=json.toJson("miss");
				return "wrong";

			}

		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}


		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}



		public UserBiz getUserBiz() {
			return userBiz;
		}



		public void setUserBiz(UserBiz userBiz) {
			this.userBiz = userBiz;
		}



		public String getVerify() {
			return verify;
		}



		public void setVerify(String verify) {
			this.verify = verify;
		}
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getPwd1() {
			return pwd1;
		}
		public void setPwd1(String pwd1) {
			this.pwd1 = pwd1;
		}
		public ShopBiz getShopBiz() {
			return shopBiz;
		}
		public void setShopBiz(ShopBiz shopBiz) {
			this.shopBiz = shopBiz;
		}

	

}
