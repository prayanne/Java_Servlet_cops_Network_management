package com.company.stacker.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
	private static final String URL = "jdbc:h2:tcp://127.0.1.1:9092/~/stackerdb";
	private static final String USER = "sa";
	private static final String PASS = "";
	
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("H2 Driver not found", e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
