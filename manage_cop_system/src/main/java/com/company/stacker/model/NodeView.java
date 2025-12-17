package com.company.stacker.model;

public class NodeView {
	private long id;
	private String nodeType;
	private String displayName;
	private int depth;
	
	public NodeView(long id, String nodeType, String displayName, int depth) {
		this.id = id;
		this.nodeType = nodeType;
		this.displayName = displayName;
		this.depth = depth;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
