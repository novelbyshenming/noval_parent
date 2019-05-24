package bean;


public class Collect {
	private long coid;
	
	private long uid;
	
	private long nid;
	
	private String ctimes;
	
	private String chapName;
	
	private Long cid;
	
	private String name;
	
   
    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getCtimes() {
		return ctimes;
	}

	public void setCtimes(String ctimes) {
		this.ctimes = ctimes;
	}

	public String getChapName() {
		return chapName;
	}

	public void setChapName(String chapName) {
		this.chapName = chapName;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Collect [coid=" + coid + ", uid=" + uid + ", nid=" + nid + ", ctimes=" + ctimes + ", chapName="
				+ chapName + ", cid=" + cid + ", name=" + name + "]";
	}


	
}
