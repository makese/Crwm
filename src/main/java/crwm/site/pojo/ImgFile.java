package crwm.site.pojo;

public class ImgFile {
    private int id;
    private String webPath;

    public ImgFile() {
    }

    public ImgFile(int id, String webPath) {
        this.id = id;
        this.webPath = webPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }
}
