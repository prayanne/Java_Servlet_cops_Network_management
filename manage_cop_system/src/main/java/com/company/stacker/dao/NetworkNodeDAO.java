package com.company.stacker.dao;

import com.company.stacker.config.Db;
import com.company.stacker.model.NetworkNode;
import com.company.stacker.model.NodeView;

import java.sql.*;
import java.util.*;

public class NetworkNodeDAO {
	public List<NetworkNode> findAllByWorkplace(long workplaceId){
		String sql = "SELECT id,workplace_id,parent_id,node_type, display_name,meta_json,sort_order FROM NETWORK_NODE WHERE workplace_id=? ORDER BY sort_order ASC, id ASC";
		List<NetworkNode> list = new ArrayList<>();
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, workplaceId);
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					NetworkNode n = new NetworkNode();
					n.setId(rs.getLong("id"));
					n.setWorkplaceId(rs.getLong("workplace_id"));
					long pid = rs.getLong("parent_id");
					n.setParentId(rs.wasNull() ? null : pid);
					n.setNodeType(rs.getString("node_type"));
					n.setDisplayName(rs.getString("display_name"));
					n.setMetaJson(rs.getString("meta_json"));
					n.setSortOrder(rs.getInt("sort_order"));
					list.add(n);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<NodeView> findFlatWithDepth(long workplaceId) {
		List<NetworkNode> nodes = findAllByWorkplace(workplaceId);
		
		Map<Long, NetworkNode> byId = new HashMap<>();
		Map<Long, List<NetworkNode>> children = new HashMap<>();
		List<NetworkNode> roots = new ArrayList<>();
		
		for (NetworkNode n : nodes) {
			byId.put(n.getId(), n);
		}
		for (NetworkNode n : nodes) {
			if(n.getParentId() == null) {
				roots.add(n);
			} else {
				children.computeIfAbsent(n.getParentId(), k -> new ArrayList<>()).add(n);
			}
		}
		
		for (List<NetworkNode> ch : children.values()) {
			ch.sort(Comparator.comparingInt(a -> a.getSortOrder()));
		}
		roots.sort(Comparator.comparingInt(a -> a.getSortOrder()));
		
		List<NodeView> out = new ArrayList<>();
		for (NetworkNode r : roots) {
			dfs(r, 0, children, out);
		}
		return out;
	}
	
	public long insert(NetworkNode n) {
	    String sql = "INSERT INTO NETWORK_NODE(workplace_id,parent_id,node_type,display_name,meta_json,sort_order) VALUES (?,?,?,?,?,?)";
	    try (Connection c = Db.getConnection();
	         PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setLong(1, n.getWorkplaceId());
	        if (n.getParentId() == null) ps.setNull(2, Types.BIGINT); else ps.setLong(2, n.getParentId());
	        ps.setString(3, n.getNodeType());
	        ps.setString(4, n.getDisplayName());
	        ps.setString(5, n.getMetaJson());
	        ps.setInt(6, n.getSortOrder());
	        ps.executeUpdate();
	        try (ResultSet keys = ps.getGeneratedKeys()) {
	            keys.next();
	            return keys.getLong(1);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public NetworkNode findById(long id) {
	    String sql = "SELECT id,workplace_id,parent_id,node_type,display_name,meta_json,sort_order FROM NETWORK_NODE WHERE id=?";
	    try (Connection c = Db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setLong(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (!rs.next()) return null;
	            NetworkNode n = new NetworkNode();
	            n.setId(rs.getLong("id"));
	            n.setWorkplaceId(rs.getLong("workplace_id"));
	            long pid = rs.getLong("parent_id");
	            n.setParentId(rs.wasNull() ? null : pid);
	            n.setNodeType(rs.getString("node_type"));
	            n.setDisplayName(rs.getString("display_name"));
	            n.setMetaJson(rs.getString("meta_json"));
	            n.setSortOrder(rs.getInt("sort_order"));
	            return n;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public String findNodeTypeById(long id) {
	    String sql = "SELECT node_type FROM NETWORK_NODE WHERE id=?";
	    try (Connection c = Db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setLong(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (!rs.next()) return null;
	            return rs.getString("node_type");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public void updateMeta(long id, String metaJson, String displayName, Integer sortOrder) {
	    String sql = "UPDATE NETWORK_NODE SET meta_json=?, display_name=?, sort_order=? WHERE id=?";
	    try (Connection c = Db.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setString(1, metaJson);
	        ps.setString(2, displayName);
	        ps.setInt(3, sortOrder == null ? 0 : sortOrder);
	        ps.setLong(4, id);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
	private void dfs(NetworkNode n, int depth, Map<Long, List<NetworkNode>> children, List<NodeView> out) {
		out.add(new NodeView(n.getId(), n.getNodeType(), n.getDisplayName(), depth));
		List<NetworkNode> ch = children.get(n.getId());
		if(ch==null) return;
		for(NetworkNode c: ch) dfs(c, depth +1, children, out);
	}
}
