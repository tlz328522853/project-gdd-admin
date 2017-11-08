package cn.hacz.edu.hibernate;


public class PageHelper {

	private int page = 1;// 当前页

	private int rows = 10;// 每页几行

	private String sort;// 根据哪个字段排序

	private String order;// 正序还是倒序 (ASC/DESC)

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
