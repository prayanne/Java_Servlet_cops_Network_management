package com.company.stacker.dao;

import com.company.stacker.config.Db;
import com.company.stacker.model.Workplace;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkplaceDAO {
	public List<Workplace> findAll() {
		
		String sql = "SELECT id,name,icon_key,location,summary,created_at FROM WORKPLACE ORDER BY id ASC";
		List<Workplace> list = new ArrayList<>();
		
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Workplace w = new Workplace();
				w.setId(rs.getLong("id"));
				w.setName(rs.getString("name"));
				w.setIconKey(rs.getString("icon_key"));
				w.setLocation(rs.getString("location"));
				w.setSummary(rs.getString("summary"));
				w.setCreatedAt(rs.getTimestamp("created_at"));
				list.add(w);
			}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}
	
	public Workplace findById(long id) {
		String sql = "SELECT id,name,icon_key,location,summary,created_at FROM WORKPLACE WHERE id=?";
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()){
				if(!rs.next()) return null;
				Workplace w = new Workplace();
				w.setId(rs.getLong("id"));
				w.setName(rs.getString("name"));
				w.setIconKey(rs.getString("icon_key"));
				w.setLocation(rs.getString("location"));
				w.setSummary(rs.getString("summary"));
				w.setCreatedAt(rs.getTimestamp("created_at"));
				return w;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public long insert(Workplace w) {
	    String sql = "INSERT INTO WORKPLACE(name,icon_key,location,summary,created_at) VALUES (?,?,?,?,CURRENT_TIMESTAMP)";
	    try (Connection c = Db.getConnection();
	         PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setString(1, w.getName());
	        ps.setString(2, w.getIconKey());
	        ps.setString(3, w.getLocation());
	        ps.setString(4, w.getSummary());
	        ps.executeUpdate();
	        try (ResultSet keys = ps.getGeneratedKeys()) {
	            keys.next();
	            return keys.getLong(1);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}
