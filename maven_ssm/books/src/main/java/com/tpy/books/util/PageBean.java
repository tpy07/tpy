package com.tpy.books.util;

import java.util.List;


public class PageBean {
	private List<Object> records;//某一张表的数据
	private int currentPage;//当前页
	private int totalPage;//总条数
	private int pageSize;//每页显示的数据
	private int firstPage=1;//首页
	private int lastPage;//末页
	private int pre;//上一页
	private int next;//下一页
	private int beginPage;//第一个显示的页码
	private int endPage;//最后显示的页码
	public PageBean(){};
	public PageBean(int currentPage, int total, int pageSize) {
		this.currentPage = currentPage;
		this.totalPage = total;
		this.pageSize = pageSize;
		lastPage=(totalPage+pageSize-1)/pageSize;//计算最后一页
		pre=currentPage-1<=0?currentPage:currentPage-1;//计算上一页
		next=currentPage+1>lastPage?lastPage:currentPage+1;//计算下一页
		//如果页码不足5页则全部显示
		if(lastPage<=5){
			beginPage=1;
			endPage=lastPage;
		}else{//如果大于5，则显示前四后五
			beginPage=currentPage-2;//第一个显示的页码是当前页的前四页
			endPage=currentPage+2;//最后一个显示的页码是当前页的后五页
			//如果当前页往前不足四个则显示前10个
			if(beginPage<1){
				beginPage=1;
				endPage=5;
			}else if(endPage>lastPage){
				endPage=lastPage;//最后一个页码为总页码
				beginPage=endPage-5+1;//第一个页码为最后一个页码向前5个
			}
		}
	}
	public List<Object> getRecords() {
		return records;
	}
	public void setRecords(List<Object> records) {
		this.records = records;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
