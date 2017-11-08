package cn.hacz.edu.page;

/**
 * project - 自定义
 *
 * @author guo
 * @date 日期:2017年8月21日 时间:下午6:19:55
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：分页辅助类-按按当前页
 */
public class Page {

	private int page = 1;// 当前页

	private int rows = 10;// 每页几行

	private String sort;// 根据哪个字段排序

	private String order;// 正序还是倒序 (ASC/DESC)

	public String getOrder() {
		return order;
	}

	public int getPage() {
		return page;
	}

	public int getRows() {
		return rows;
	}

	public String getSort() {
		return sort;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
