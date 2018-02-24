package cn.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0Connection {
	
	private static C3P0Connection instance = null;
	private static ComboPooledDataSource  dataSource = null;
	
	private C3P0Connection() {
		dataSource = new ComboPooledDataSource();
	}
	
	public static final C3P0Connection getInstance() {
		if(instance == null) {
			instance = new C3P0Connection();
		}
		return instance;
	}
	
	public synchronized final Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
