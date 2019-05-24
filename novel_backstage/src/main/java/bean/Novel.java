package bean;

/**
 * @author LX
 * @date 2019/5/12 - 14:17
 */
public class Novel {
	
	private int nid;
	private String novelName;
	private String introduction;
	private String url;
	private String author;
	private String type;
	private String image;
	private String latestChapters;
	private String latestChaptersUrl;
	private String updateTimes;
	private String tdate;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
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
	public void setImage(String image) {
		this.image = image;
	}
	public String getLatestChapters() {
		return latestChapters;
	}
	public void setLatestChapters(String latestChapters) {
		this.latestChapters = latestChapters;
	}
	public String getLatestChaptersUrl() {
		return latestChaptersUrl;
	}
	public void setLatestChaptersUrl(String latestChaptersUrl) {
		this.latestChaptersUrl = latestChaptersUrl;
	}
	public String getUpdateTimes() {
		return updateTimes;
	}
	public void setUpdateTimes(String updateTimes) {
		this.updateTimes = updateTimes;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	@Override
	public String toString() {
		return "Novel [nid=" + nid + ", novelName=" + novelName + ", introduction=" + introduction + ", url=" + url
				+ ", author=" + author + ", type=" + type + ", image=" + image + ", latestChapters=" + latestChapters
				+ ", latestChaptersUrl=" + latestChaptersUrl + ", updateTimes=" + updateTimes + ", tdate=" + tdate
				+ "]";
	}
	
	
	
	
}
