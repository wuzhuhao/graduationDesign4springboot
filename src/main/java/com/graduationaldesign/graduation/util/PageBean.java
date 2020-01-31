package com.graduationaldesign.graduation.util;

import java.util.List;
import java.util.Map;

/**
 * 分页封装
 * @param <T>
 */
public class PageBean<T> {
	/**
	 * 当前页数
	 */
	private int currentPage;
	/**
	 * 数据总数量
	 */
	private int totalRecord;
	/**
	 * 单页数量
	 */
	private int pageSize;
	/**
	 * 数据
	 */
	private List<T> beanList;
	/**
	 * 请求url
	 */
	private String url;
	/**
	 * 查询条件保存
	 */
	private Map<String, Object> params;

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		int totalPage = totalRecord / pageSize + (totalRecord % pageSize == 0 ? 0 : 1);
		return totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"currentPage=" + currentPage +
				", totalRecord=" + totalRecord +
				", pageSize=" + pageSize +
				", beanList=" + beanList +
				", url='" + url + '\'' +
				", params=" + params +
				'}';
	}
}
