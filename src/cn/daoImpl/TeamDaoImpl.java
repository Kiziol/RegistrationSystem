package cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.TeamDao;
import cn.db.C3P0Connection;

public class TeamDaoImpl implements TeamDao {
	
	private Connection conn = null;
	private static TeamDao instance;
	
	public TeamDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}
	
	public static final TeamDao getInstance() {
		if(instance == null) {
			instance = new TeamDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int getTeamId(String username) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		int flag = 0;
		String sql = "select tid from team where username = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			res = pstmt.executeQuery();
			while(res.next()) {
				flag = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}


}
