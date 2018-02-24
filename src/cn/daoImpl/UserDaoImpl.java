package cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import cn.dao.UserDao;
import cn.db.C3P0Connection;
import cn.utils.DBUtils;

public class UserDaoImpl implements UserDao {
	
	private Connection conn = null;
	private static UserDao instance = null;
	
	private UserDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}
	
	public static final UserDao getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public boolean register(String username, String password, String teamname) {
		// TODO Auto-generated method stub
		int flag = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into team(username, password, teamname) values (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, teamname);
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt);
		}
		if(flag == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int login(String username, String password) {
		int flag = 0;
		boolean next = true;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet res = null;
		String sql1 = "select * from admin where username = ?";
		String sql2 = "select * from team where username = ?";
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, username);
			res = pstmt1.executeQuery();
			while(res.next()) {
				String ps = res.getString("password");
				if(ps.equals(password)) {
					flag = 1;
					next = false;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt1, res);
		}
		if(next == true) {
			try {
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, username);
				res = pstmt2.executeQuery();
				while(res.next()) {
					String ps = res.getString("password");
					if(ps.equals(password)) {
						flag = 2;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtils.close(pstmt2, res);
			}
		}
		return flag;
	}

}
