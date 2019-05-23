package bean;

/**
 * @author LX
 * @date 2019/5/12 - 14:17
 */
public class IndexNovel {
	
	private int id;
	private String novelName;
	private String author;
	private int readPeople;
	private String picture;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNovelName() {
		return novelName;
	}
	public void setNovelName(String novelName) {
		this.novelName = novelName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getReadPeople() {
		return readPeople;
	}
	public void setReadPeople(int readPeople) {
		this.readPeople = readPeople;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "IndexNovel [id=" + id + ", novelName=" + novelName + ", author=" + author + ", readPeople=" + readPeople
				+ ", picture=" + picture + "]";
	}
	
	
	
	
}
