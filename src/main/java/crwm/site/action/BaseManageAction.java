package crwm.site.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import crwm.site.pojo.ImgFile;
import org.apache.struts2.ServletActionContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by makese on 2017/10/19.
 */
public abstract class BaseManageAction<T> extends ActionSupport {
    private List<T> data = new ArrayList<>();
    private String options = "";
    private Map<String,Map> files = new HashMap<String,Map>();
    private Type type = getType();

    BaseManageAction(){
       files.put("files",new HashMap<>());
    }

    public abstract String load();

    public String edit(){
        return SUCCESS;
    };

    public String remove(){
        return SUCCESS;
    };

    public String create(){
        return SUCCESS;
    };

    public abstract Type getType();

    void jsonToData() {
        Gson gson = new GsonBuilder().create();
        try {
            BufferedReader reader = ServletActionContext.getRequest().getReader();
            data = gson.fromJson(reader,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void addImage(ImgFile imgFile){
        files.get("files").put(imgFile.getId(),imgFile);
    }
    public void removeImage(ImgFile imgFile){
        files.get("files").remove(imgFile.getId());
    }

    public Map<String, Map> getFiles() {
        return files;
    }

    public void setFiles(Map<String, Map> files) {
        this.files = files;
    }
}
