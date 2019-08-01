package com.shxt.manager.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ��ҳ
 */
public class Pager {
	/**��ǰҳ,Ĭ��ֵΪ1*/
	private int pageNow=1;
	/**ÿҳ��ʾ����,Ĭ��ֵΪ1*/
	private int pageSize=5;
	/**�ܼ�¼��*/
	private int totalCount;
	/**ÿ��ҳ��*/
	private int totalPages;
	private int offset;//(pageNow-1)*pageSize
	/**������*/
	private List<?> datas;

	private Map<String, Object> query=new HashMap<String, Object>();

	public int getPageNow() {
		return this.pageNow;
	}

	public void setPageNow( int pageNow ) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize( int pageSize ) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount( int totalCount ) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		int flag=this.totalCount%this.pageSize;
		this.totalPages=flag==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
		return this.totalPages;
	}

	public void setTotalPages( int totalPages ) {
		this.totalPages = totalPages;
	}

	public int getOffset() {
		this.offset=(this.pageNow-1)*this.pageSize;
		return this.offset;
	}

	public void setOffset( int offset ) {
		this.offset = offset;
	}

	public List<?> getDatas() {
		return this.datas;
	}

	public void setDatas( List<?> datas ) {
		this.datas = datas;
	}

	public Map<String, Object> getQuery() {
		return this.query;
	}

	public void setQuery( Map<String, Object> query ) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "Pager [pageNow=" + this.pageNow + ", pageSize=" + this.pageSize + ", totalCount=" + this.totalCount
				+ ", totalPages=" + this.totalPages + ", offset=" + this.offset + ", datas=" + this.datas + ", query="
				+ this.query + "]";
	}
}
