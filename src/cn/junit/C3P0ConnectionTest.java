package cn.junit;

import java.sql.Connection;

import org.junit.Test;

import cn.db.C3P0Connection;

public class C3P0ConnectionTest {
	@Test
	public void getConnectionTest() {
		Connection conn = C3P0Connection.getInstance().getConnection();
		if(conn != null) {
			System.out.println("hello world");
		}
	}
}
