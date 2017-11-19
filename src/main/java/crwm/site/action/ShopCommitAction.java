package crwm.site.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.ShopBiz;
import crwm.site.biz.ShopTypeBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopAptitude;
import crwm.site.pojo.ShopInfo;
import crwm.site.pojo.ShopScore;
import crwm.site.pojo.ShopType;
import crwm.site.util.SendEmail;
@Controller
@Scope("prototype")
public class ShopCommitAction {
	@Resource
	private ShopTypeBiz shopTypeBiz;
	@Resource
	private ShopBiz shopBiz;
	private String result;
	private String shopName;
	private String shopTel;
	private String shopAddress;
	private String shopType;
	private String s_province;
	private String s_city;
	private String s_county;
	private Shop currShop;
	private ShopInfo shopInfo=null;
	private ShopAptitude shopAptitude=null;
	private ShopScore shopScore=null;
	private ShopType shoptype=null;
	private File imgZ;
	private String imgZFileName;
	private File imgF;
	private String imgFFileName;
	private PrintWriter pw=null;
	private File shopImg;
	private File businessLicenseImg;
	private File foodLicense;
	private String shopImgFileName;
	private String businessLicenseImgFileName;
	private String foodLicenseFileName;
	public String preDo(){
		
		Set<ShopType> shopTypeSet=shopTypeBiz.getSet();
		ActionContext.getContext().getSession().put("shopTypeSet", shopTypeSet);
		return "success";
		
	}
	public String commit(){
			Gson json=new Gson();
//		System.out.println(shopName+"=="+shopTel+"=="+shopAddress+"=="+shopType+"=="+s_city+"=="+s_county+"=="+s_province);
		if(StringUtils.isBlank(shopName) || StringUtils.isEmpty(shopName)){
			
			result=json.toJson("noShopName");
			return "commit";
		}
		if(StringUtils.isBlank(shopTel) || StringUtils.isEmpty(shopTel)){
			
			result=json.toJson("noShopTel");
			return "commit";
		}
		if(StringUtils.isBlank(shopType) || StringUtils.isEmpty(shopType) || "请选择".equals(shopType)){
		
		result=json.toJson("noShopType");
		return "commit";
		}
		if(StringUtils.isBlank(s_province) || StringUtils.isEmpty(s_province) || "省份".equals(s_province)){
			
			result=json.toJson("nos_province");
			return "commit";
		}
		if(StringUtils.isBlank(s_city) || StringUtils.isEmpty(s_city)|| "地级市".equals(s_city)){
			
			result=json.toJson("nos_city");
			return "commit";
		}
		if(StringUtils.isBlank(s_county) || StringUtils.isEmpty(s_county)|| "市、县级市".equals(s_county)){
			
			result=json.toJson("nos_county");
			return "commit";
		}
		if(StringUtils.isBlank(shopAddress) || StringUtils.isEmpty(shopAddress)){
		
		result=json.toJson("noShopAddress");
		return "commit";
		}
		if(shopTel.contains("*")){
			shopTel=shopTel.substring(0, 11);
			
		}else if(shopBiz.getShopByTel(shopTel)!=null){//说明该手机号已经绑定账号
			result=json.toJson("existTel");
			return "commit";
			
		}
		Object currShopObj=ServletActionContext.getRequest().getSession().getAttribute("currShop");
		if(currShopObj==null){
			result=json.toJson("nocurrShopObj");
			return "commit";
			
		}else{
			currShop=(Shop)currShopObj;
			if(shopInfo==null){
				shopInfo=new ShopInfo();
			}
			if(shoptype==null){
				shoptype=shopTypeBiz.getTypeByTypeName(shopType);
			}
			StringBuilder addressBuilder=new StringBuilder(s_province).append(s_city).append(s_city)
					.append(shopAddress);
			String address=addressBuilder.toString();
			currShop.setTel(shopTel);
			shopInfo.setShopAddress(address);
			shopInfo.setShopName(shopName);
			shopInfo.setShop(currShop);
			currShop.setShopInfo(shopInfo);
			currShop.setShopType(shoptype);
			shopBiz.update(currShop);
			ActionContext.getContext().getSession().put("currShop", currShop);
			result=json.toJson("ok");
			return "commit";
		}
		

	}
	public String commitIdentify(){
		Object currShopObj=ServletActionContext.getRequest().getSession().getAttribute("currShop");
		if(currShopObj==null){
			try {
				pw=ServletActionContext.getResponse().getWriter();
				pw.println("<script type='text/jacascript'>");
				pw.println("alert('没有注册账号')");
				pw.println("window.top.location.href='shopindex.jsp'");
				pw.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "commitIdentIfy";
		}else{
			if(imgF==null || imgZ==null){
				
				return "commiterror";
				
			}
			
			
			
			currShop=(Shop)currShopObj;
		File destFileZ=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg"+"/"+imgZFileName);
		File destFileF=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg"+"/"+imgFFileName);
		try {
				FileUtils.copyFile(imgZ, destFileZ);
				FileUtils.copyFile(imgF, destFileF);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(shopAptitude==null){
			shopAptitude=new ShopAptitude();
		}
		shopAptitude.setIDCardImgZ("shopImgs"+"/"+currShop.getTel()+"//shopImg"+"/"+imgZFileName);
		shopAptitude.setIDCardImgF("shopImgs"+"/"+currShop.getTel()+"//shopImg"+"/"+imgFFileName);
		shopAptitude.setShop(currShop);
		currShop.setShopAptitude(shopAptitude);
		shopBiz.update(currShop);
		ServletActionContext.getRequest().getSession().setAttribute("currShop", currShop);
		return "commitIdentIfy";
		
		
		
	}
	public String commitAptitude(){
		Object currShopObj=ServletActionContext.getRequest().getSession().getAttribute("currShop");
		if(currShopObj==null){
			try {
				pw=ServletActionContext.getResponse().getWriter();
				pw.println("<script type='text/jacascript'>");
				pw.println("alert('没有注册账号')");
				pw.println("window.top.location.href='shopindex.jsp'");
				pw.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "commitAptitude";
		}else{
			
				if(shopImg==null || businessLicenseImg==null || foodLicense==null){
				
				return "commitIdentIfy";
				
			}
			
			currShop=(Shop)currShopObj;
			
		File srcdir=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg");
		File desdir=new File("H://Workspaces//MyEclipse 2017 CI//Crwm//src//main//webapp//shopImgs"+"/"+currShop.getTel());
		File destFileShopImg=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg"+"/"+shopImgFileName);
		File destFileBLImg=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg"+"/"+businessLicenseImgFileName);
		File destFileFLImg=new File(ServletActionContext.getServletContext().getRealPath("/shopImgs")+"/"+currShop.getTel()+"//shopImg"+"/"+foodLicenseFileName);
		
		try {
				FileUtils.copyFile(shopImg, destFileShopImg);
				FileUtils.copyFile(businessLicenseImg, destFileBLImg);
				FileUtils.copyFile(foodLicense, destFileFLImg);
				FileUtils.copyDirectoryToDirectory(srcdir, desdir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(shopAptitude==null){
			shopAptitude=currShop.getShopAptitude();
		}
		shopAptitude.setShopImg("shopImgs"+"/"+currShop.getTel()+"//shopImg"+"/"+shopImgFileName);
		shopAptitude.setBusinessLicenseImg("shopImgs"+"/"+currShop.getTel()+"//shopImg"+"/"+businessLicenseImgFileName);
		shopAptitude.setFoodLicense("shopImgs"+"/"+currShop.getTel()+"//shopImg"+"/"+foodLicenseFileName);
		shopBiz.update(currShop);
		ServletActionContext.getRequest().getSession().setAttribute("currShop", currShop);
		return "commitAptitude";
		
		
		
	}
	public String commitSuccess(){
		String adminAddr="568550317@qq.com";
//		String adminAddr="939800267@qq.com";
		SendEmail.send(adminAddr);
		return "ok";
	}
	public ShopTypeBiz getShopTypeBiz() {
		return shopTypeBiz;
	}
	public void setShopTypeBiz(ShopTypeBiz shopTypeBiz) {
		this.shopTypeBiz = shopTypeBiz;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopTel() {
		return shopTel;
	}
	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public String getShopType() {
		return shopType;
	}
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}
	public String getS_province() {
		return s_province;
	}
	public void setS_province(String s_province) {
		this.s_province = s_province;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_county() {
		return s_county;
	}
	public void setS_county(String s_county) {
		this.s_county = s_county;
	}
	public ShopBiz getShopBiz() {
		return shopBiz;
	}
	public void setShopBiz(ShopBiz shopBiz) {
		this.shopBiz = shopBiz;
	}
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	public ShopAptitude getShopAptitude() {
		return shopAptitude;
	}
	public void setShopAptitude(ShopAptitude shopAptitude) {
		this.shopAptitude = shopAptitude;
	}
	public ShopScore getShopScore() {
		return shopScore;
	}
	public void setShopScore(ShopScore shopScore) {
		this.shopScore = shopScore;
	}
	public ShopType getShoptype() {
		return shoptype;
	}
	public void setShoptype(ShopType shoptype) {
		this.shoptype = shoptype;
	}
	public File getImgZ() {
		return imgZ;
	}
	public void setImgZ(File imgZ) {
		this.imgZ = imgZ;
	}

	public String getImgZFileName() {
		return imgZFileName;
	}
	public void setImgZFileName(String imgZFileName) {
		this.imgZFileName = imgZFileName;
	}
	public File getImgF() {
		return imgF;
	}
	public void setImgF(File imgF) {
		this.imgF = imgF;
	}

	public String getImgFFileName() {
		return imgFFileName;
	}
	public void setImgFFileName(String imgFFileName) {
		this.imgFFileName = imgFFileName;
	}
	public PrintWriter getPw() {
		return pw;
	}
	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
	public Shop getCurrShop() {
		return currShop;
	}
	public void setCurrShop(Shop currShop) {
		this.currShop = currShop;
	}
	public File getShopImg() {
		return shopImg;
	}
	public void setShopImg(File shopImg) {
		this.shopImg = shopImg;
	}
	public File getBusinessLicenseImg() {
		return businessLicenseImg;
	}
	public void setBusinessLicenseImg(File businessLicenseImg) {
		this.businessLicenseImg = businessLicenseImg;
	}
	public File getFoodLicense() {
		return foodLicense;
	}
	public void setFoodLicense(File foodLicense) {
		this.foodLicense = foodLicense;
	}
	public String getShopImgFileName() {
		return shopImgFileName;
	}
	public void setShopImgFileName(String shopImgFileName) {
		this.shopImgFileName = shopImgFileName;
	}
	public String getBusinessLicenseImgFileName() {
		return businessLicenseImgFileName;
	}
	public void setBusinessLicenseImgFileName(String businessLicenseImgFileName) {
		this.businessLicenseImgFileName = businessLicenseImgFileName;
	}
	public String getFoodLicenseFileName() {
		return foodLicenseFileName;
	}
	public void setFoodLicenseFileName(String foodLicenseFileName) {
		this.foodLicenseFileName = foodLicenseFileName;
	}

}
