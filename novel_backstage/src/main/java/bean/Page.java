package bean;


import java.util.List;

/**
 * 分页
 */
public class Page<Novel>  {
 

 
	private int currPage; // 当前页数
 
	private int pageSize; // 每页显示记录的条数
 
	private int totalCount; // 总的记录条数
 
	private int totalPage; // 总的页数
	private List<Novel> list;//封装某个页面
	
	 public Page() {
         super();
     }
	public Page(List<Novel> list2, int i) {
		// TODO Auto-generated constructor stub
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Novel> getList() {
		return list;
	}
	public void setList(List<Novel> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
 
	
 
}