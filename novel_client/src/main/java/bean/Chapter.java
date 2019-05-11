package bean;

/**
 * 
 * @author sm
 */
public class Chapter {
	
	private long cid;
	
	private long nid;
	
	private String novalName;
	
	private String novalChapter;
	
	private String url;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getNovalName() {
		return novalName;
	}

	public void setNovalName(String novalName) {
		this.novalName = novalName;
	}

	public String getNovalChapter() {
		return novalChapter;
	}

	public void setNovalChapter(String novalChapter) {
		this.novalChapter = novalChapter;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Chapter [cid=" + cid + ", nid=" + nid + ", novalName=" + novalName + ", novalChapter=" + novalChapter
				+ ", url=" + url + "]";
	}
	
}
