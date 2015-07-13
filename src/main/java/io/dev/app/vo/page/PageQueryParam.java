package io.dev.app.vo.page;

/**
 * desc:
 * 
 * @author lsr
 * @version 2014年6月30日
 */
public class PageQueryParam {
	private short pageSize;// 每页大小
	private short pageNo;// 页码

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

}
