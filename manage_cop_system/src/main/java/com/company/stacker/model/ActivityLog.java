package com.company.stacker.model;

import java.sql.Timestamp;

public class ActivityLog {
	private long id;
	private long nodeId;
	private Timestamp occurredAt;
	private String title;
	private String content;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNodeId() {
		return nodeId;
	}
	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}
	public Timestamp getOccurredAt() {
		return occurredAt;
	}
	public void setOccurredAt(Timestamp occurredAt) {
		this.occurredAt = occurredAt;
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
	
	
}
