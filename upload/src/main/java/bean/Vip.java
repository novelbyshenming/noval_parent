package bean;


public class Vip {
	private Long vid;
	
	private Long uid;
	
	private Long startTimes;
	
	private Long endTimes;
	
	private Integer flag;
	

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getVid() {
		return vid;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(Long startTimes) {
		this.startTimes = startTimes;
	}

	public Long getEndTimes() {
		return endTimes;
	}

	public void setEndTimes(Long endTimes) {
		this.endTimes = endTimes;
	}

	@Override
	public String toString() {
		return "Vip [vid=" + vid + ", uid=" + uid + ", startTimes=" + startTimes + ", endTimes=" + endTimes + ", flag="
				+ flag + "]";
	}

	
	
	
}
