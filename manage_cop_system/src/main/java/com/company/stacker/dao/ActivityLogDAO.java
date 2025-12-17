package com.company.stacker.dao;

import com.company.stacker.config.Db;
import com.company.stacker.model.ActivityLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityLogDAO {
	public List<ActivityLog> findByNode(long nodeId) {
		String sql = "SELECT id,node_id,occurred_at, title,content FROM ACTIVITY_LOG WHERE node_id=? ORDER BY occurred_at DESC, id DESC";
		List<ActivityLog> list = new ArrayList<>();
		
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setLong(1, nodeId);
			
			try (ResultSet rs = ps.executeQuery()){
				while (rs.next()) {
					ActivityLog a = new ActivityLog();
					a.setId(rs.getLong("id"));
					a.setNodeId(rs.getLong("node_id"));
					a.setOccurredAt(rs.getTimestamp("occurred_at"));
					a.setTitle(rs.getString("title"));
					a.setContent(rs.getString("content"));
					list.add(a);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	public ActivityLog findById(long id) {
	    String sql = "SELECT id,node_id,occurred_at,title,content FROM ACTIVITY_LOG WHERE id=?";
	    try (Connection c = Db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setLong(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (!rs.next()) return null;
	            ActivityLog a = new ActivityLog();
	            a.setId(rs.getLong("id"));
	            a.setNodeId(rs.getLong("node_id"));
	            a.setOccurredAt(rs.getTimestamp("occurred_at"));
	            a.setTitle(rs.getString("title"));
	            a.setContent(rs.getString("content"));
	            return a;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public long insert(ActivityLog a) {
	    String sql = "INSERT INTO ACTIVITY_LOG(node_id,occurred_at,title,content) VALUES (?, CURRENT_TIMESTAMP, ?, ?)";
	    try (Connection c = Db.getConnection();
	         PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setLong(1, a.getNodeId());
	        ps.setString(2, a.getTitle());
	        ps.setString(3, a.getContent());
	        ps.executeUpdate();
	        try (ResultSet keys = ps.getGeneratedKeys()) {
	            keys.next();
	            return keys.getLong(1);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public void update(long id, String title, String content) {
	    String sql = "UPDATE ACTIVITY_LOG SET title=?, content=? WHERE id=?";
	    try (Connection c = Db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setString(1, title);
	        ps.setString(2, content);
	        ps.setLong(3, id);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}
