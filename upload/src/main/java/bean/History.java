package bean;

/**
 * 
 * @author sm
 *小说章节阅览记忆
 */
public class History {

	private long hid;
	
	private long uid;
	
	private long nid;
	
	private String latestChaptersUrl;

	public long getHid() {
		return hid;
	}

	public void setHid(long hid) {
		this.hid = hid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getLatestChaptersUrl() {
		return latestChaptersUrl;
	}

	public void setLatestChaptersUrl(String latestChaptersUrl) {
		this.latestChaptersUrl = latestChaptersUrl;
	}

	@Override
	public String toString() {
		return "History [hid=" + hid + ", uid=" + uid + ", nid=" + nid + ", latestChaptersUrl=" + latestChaptersUrl
				+ "]";
	}

	
	
}
