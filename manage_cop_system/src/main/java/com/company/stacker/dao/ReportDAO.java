package com.company.stacker.dao;

import com.company.stacker.config.Db;
import com.company.stacker.model.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
	public List<Report> findByWorkplace(long workplaceId){
		String sql = "SELECT id,workplace_id,report_date,title,author,tags_csv,created_at,updated_at FROM REPORT WHERE workplace_id=? ORDER BY created_at DESC, id DESC";
		List<Report> list = new ArrayList<>();
		
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setLong(1, workplaceId);
			try(ResultSet rs = ps.executeQuery()){
				while (rs.next()) list.add(mapLite(rs));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public Report findById(long id) {
		String sql = "SELECT id,workplace_id,report_date,title,content,author,tags_csv,created_at,updated_at FROM REPORT WHERE id=?";
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()){
				if (!rs.next()) return null;
				Report r = new Report();
				r.setId(rs.getLong("id"));
				r.setWorkplaceId(rs.getLong("workplace_id"));
				r.setReportDate (rs.getDate("report_date"));
				r.setTitle(rs.getString("title"));
				r.setContent(rs.getString("content"));
				r.setAuthor(rs.getString("author"));
				r.setTagsCsv(rs.getString("tags_csv"));
				r.setCreatedAt(rs.getTimestamp("created_at"));
				r.setUpdatedAt(rs.getTimestamp("updated_at"));
				return r;
						
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public long insert (Report r) {
		String sql = "INSERT INTO REPORT(workplace_id,report_date,title,content,author,tags_csv,created_at,updated_at) VALUES (?,?,?,?,?,?,CURRENT_TIMESTAMP,NULL)";
		try (Connection c = Db.getConnection();
				PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setLong(1, r.getWorkplaceId());
			if (r.getReportDate() == null) ps.setNull(2, Types.DATE); else ps.setDate(2, r.getReportDate());
			ps.setString(3, r.getTitle());
			ps.setString(4, r.getContent());
			ps.setString(5, r.getAuthor());
			ps.setString(6, r.getTagsCsv());
			ps.executeUpdate();
			try (ResultSet keys = ps.getGeneratedKeys()){
				keys.next();
				return keys.getLong(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Report mapLite(ResultSet rs) throws SQLException {
		Report r = new Report();
		r.setId(rs.getLong("id"));
		r.setWorkplaceId(rs.getLong("workplace_id"));
		r.setReportDate(rs.getDate("report_date"));
		r.setTitle(rs.getString("title"));
		r.setAuthor(rs.getString("author"));
		r.setTagsCsv(rs.getString("tags_csv"));
		r.setCreatedAt(rs.getTimestamp("created_at"));
		r.setUpdatedAt(rs.getTimestamp("updated_at"));
		return r;
	}
}
