package crwm.site.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.FoodBiz;
import crwm.site.biz.SequenceBiz;
import crwm.site.pojo.ImgFile;
import crwm.site.pojo.Shop;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
public class UploadAction {
    private File upload;
    private String uploadFileName;

    @Resource
    private FoodBiz foodBiz;
    @Resource
    private SequenceBiz sequenceBiz;

    public void upload(){
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        long no = sequenceBiz.getNum();
        File file = new File(ServletActionContext.getServletContext().getRealPath("/shopImgs") + "/" + shop.getTel() + "/foodImg/" + no + ".jpg");
        try {
            FileUtils.copyFile(upload,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImgFile imgFile = new ImgFile();
        imgFile.setId((int) no);
        imgFile.setWebPath("shopImgs/" + shop.getTel() + "/foodImg/" + no + ".jpg" );
        JsonObject result = new JsonObject();
        Map<String,Map> files = new HashMap<String,Map>();
        files.put("files",new HashMap<>());
        files.get("files").put(imgFile.getId(),imgFile);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id",imgFile.getId());
        Gson gson = new GsonBuilder().create();
        result.add("files",gson.toJsonTree(files));
        result.add("upload",jsonObject);
        try {
            PrintWriter writer = ServletActionContext.getResponse().getWriter();
            gson.toJson(result,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}
