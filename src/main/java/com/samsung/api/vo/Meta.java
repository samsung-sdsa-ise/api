/**
 * Copyright (c) 2016 Samsung SDSA. All Rights Reserved.
 */
package com.samsung.api.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Meta implements Serializable 
{
	private static final long serialVersionUID = -7290111095544086823L;

	@JsonInclude(value = Include.NON_NULL)
	private Object success;
	@JsonInclude(value = Include.NON_NULL)
	private String message;
	@JsonInclude(value = Include.NON_NULL)
	private String error_code;
	@JsonInclude(value = Include.NON_NULL)
	private Integer pages;
	@JsonInclude(value = Include.NON_NULL)
	private Integer total;
	@JsonInclude(value = Include.NON_NULL)
	private Integer page;
	@JsonInclude(value = Include.NON_NULL)
	private Integer per_page;
	@JsonInclude(value = Include.NON_NULL)
	private String sortField;
	@JsonInclude(value = Include.NON_NULL)
	private String sortDir;
	@JsonInclude(value = Include.NON_NULL)
	private Object valid_session;

	public Integer getPages() {
		if (null != per_page && null != total) {
			int pageCount = 0;
			int totalValue = Integer.parseInt(total.toString());
			int perPageValue = Integer.parseInt(per_page.toString());
			pageCount = (totalValue / perPageValue);
			if ((totalValue % perPageValue) > 0)
				pageCount = pageCount + 1;
			this.pages = new Integer(pageCount);
		}
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Object getSuccess() {
		return success;
	}

	public void setSuccess(Object success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		if (null != page) {
			this.page = new Integer(page.toString());
		}
		return page;
	}

	public void setPage(Integer object) {
		this.page = object;
	}

	public Integer getPer_page() {
		if (null != per_page) {
			this.per_page = new Integer(per_page.toString());
		}
		return per_page;
	}

	public void setPer_page(Integer object) {
		this.per_page = object;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public Object getValid_session() {
		return valid_session;
	}

	public void setValid_session(Object valid_session) {
		this.valid_session = valid_session;
	}

	@Override
	public String toString() {
		return "Meta [success=" + success + ", message=" + message + ", total="
				+ total + ", page=" + page + ", per_page=" + per_page
				+ ", sortField=" + sortField + ", sortDir=" + sortDir
				+ ", valid_session=" + valid_session + "]";
	}

}
