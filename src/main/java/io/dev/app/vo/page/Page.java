package io.dev.app.vo.page;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * desc: 分页对象
 * 
 * @author lsr
 * @version 2014年6月30日
 */
public class Page<T> {
	public static final byte DEFAULT_PAGE_NO = 1;
	public static final byte DEFAULT_PAGE_SIZE = 10;
	public static final byte DEFAULT_START_INDEX = 1;
	private short pageSize;// 每页大小
	private short pageNo;// 页码
	private long totalCount; // 总计录数
	private long totalPage; // 总页数
	private List<T> items;// 记录

	public short getPageSize() {
		return pageSize;
	}

	public void setPageSize(short pageSize) {
		this.pageSize = pageSize;
	}

	public short getPageNo() {
		return pageNo;
	}

	public void setPageNo(short pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public Page(short pageSize, short pageNo, long totalCount, List<T> items) {
		super();
		this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
		this.pageNo = pageNo <= 0 ? DEFAULT_PAGE_NO : pageNo;
		this.totalCount = totalCount;
		this.items = items;
		
		if(totalCount == 0)
			totalPage = 0;
		else
			totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
	}

}
