package bean;

public class Collect {
	private long cid;
	
	private long uid;
	
	private long nid;
	
	private long ctime;

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
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

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "Collect [cid=" + cid + ", uid=" + uid + ", nid=" + nid + ", ctime=" + ctime + "]";
	}
	
	
}
