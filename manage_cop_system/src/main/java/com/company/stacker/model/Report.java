package com.company.stacker.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Report {
	private long id;
	private long workplaceId;
	private Date reportDate;
	private String title;
	private String content;
	private String author;
	private String tagsCsv;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWorkplaceId() {
		return workplaceId;
	}
	public void setWorkplaceId(long workplaceId) {
		this.workplaceId = workplaceId;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTagsCsv() {
		return tagsCsv;
	}
	public void setTagsCsv(String tagsCsv) {
		this.tagsCsv = tagsCsv;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
