package bean;


public class Collect {
	private long coid;
	
	private long uid;
	
	private long nid;
	
	private String ctime;
	
	private String chapname;
	
	private Long cid;
	

	public long getCoid() {
		return coid;
	}

	public void setCoid(long coid) {
		this.coid = coid;
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

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getChapname() {
		return chapname;
	}

	public void setChapname(String chapname) {
		this.chapname = chapname;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Collect [coid=" + coid + ", uid=" + uid + ", nid=" + nid + ", ctime=" + ctime + ", chapname=" + chapname
				+ ", cid=" + cid + "]";
	}

	
}
