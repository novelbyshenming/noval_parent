package bean;

/**
 * @author LX
 * @date 2019/5/2 - 21:08
 */
public class Novel {

    private long nid;

    private String novelName;

    private String introduction;

    private String url;

    private String author;

    private String type;

    private String image;

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "nid=" + nid +
                ", novelName='" + novelName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setImage(String image) {
        this.image = image;
    }
}
