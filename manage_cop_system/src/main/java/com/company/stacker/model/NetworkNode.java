package com.company.stacker.model;

public class NetworkNode {
	private long id;
	private long workplaceId;
	private Long parentId;
	private String nodeType;
	private String displayName;
	private String metaJson;
	private int sortOrder;
	
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
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getMetaJson() {
		return metaJson;
	}
	public void setMetaJson(String metaJson) {
		this.metaJson = metaJson;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
}
