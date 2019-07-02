package com.sxt.order.page;

import java.util.List;

/**
 * 分页工具类
 * @author Lisa Li
 * @param <T>
 *
 */
public class Page<T> {
	
	private Integer pageNum; // 当前页 （前台传递参数；若前台未传递，默认当前页为第一页）
	private Integer pageSize; // 每页显示的数量 （可以是前台传递，也可以是后台定义；若前台传递则以前台传递参数为准；若未穿传递，则使用后台定义）
	private long totalCount; // 总数量  （数据库通过count()函数获取）
	private String url;		//前台请求的url
	
	public Integer totalPages; // 总页数  （总数量/每页显示的数量（转浮点类型），向上取整）
	private Integer pre; // 上一页  （当前页-1；若当前页-1的值小于1，则上一页的值为1）
	private Integer next; // 下一页 （当前页+1；若当前页+1大于总页数，则下一页的值为总页数）
	private Integer start; // 开始导航数  （当前页-3；若当前页-3的值小于1，则开始数为1,，此时结束数为开始数+5；若结束数大于总页数，结束数为总页数）
	private Integer end; // 结束导航数  （当前页+2；若当前页+2大于总页数，结束数为总页数，此时开始数为结束数-5；若开始数小于1，开始数为1）
	
	
	private List<T> dataList; // 当前页显示的数据列表   （数据库通过limit参数查询得到的集合）
	
	

	/**
	 * 通过当前页、每页显示的数量及总数量得到其他参数的值
	 * @param pageNum
	 * @param pageSize
	 * @param totalCount
	 */
	public Page(Integer pageNum, Integer pageSize, long totalCount, String url, List<T>dataList) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.url =url;
		this.dataList =dataList;
		
		// 总页数  （总数量/每页显示的数量（转浮点类型），向上取整）
		totalPages = (int) Math.ceil((totalCount/(pageSize*1.0)));
		
		// 上一页  （当前页-1；若当前页-1的值小于1，则上一页的值为1）
		pre = pageNum - 1 < 1 ? 1 : pageNum - 1;
		
		// 下一页 （当前页+1；若当前页+1大于总页数，则下一页的值为总页数）
		next = pageNum + 1 > totalPages ? totalPages : pageNum + 1;
		
		
		start = pageNum - 3; 
		end = pageNum + 2;
		// 开始导航数  （当前页-3；若当前页-3的值小于1，则开始数为1,，此时结束数为开始数+5；若结束数大于总页数，结束数为总页数）
		if (start < 1) {
			start = 1; // 若当前页-3的值小于1，则开始数为1
			end = start + 5 >  totalPages ? totalPages : start + 5; // 此时结束数为开始数+9；若结束数大于总页数，结束数为总页数
		}
		
		// 结束导航数  （当前页+2；若当前页+2大于总页数，结束数为总页数，此时开始数为结束数-5；若开始数小于1，开始数为1）
		if (end > totalPages) {
			end = totalPages; // 若当前页+4大于总页数，结束数为总页
			start = end - 5 < 1 ? 1 : end - 5 ; // 此时开始数为结束数-5；若开始数小于1，开始数为1
		} 

	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPre() {
		return pre;
	}

	public void setPre(Integer pre) {
		this.pre = pre;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
