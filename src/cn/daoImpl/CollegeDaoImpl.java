package cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.CollegeDao;
import cn.db.C3P0Connection;
import cn.utils.DBUtils;

public class CollegeDaoImpl implements CollegeDao {
	
	private Connection conn = null;
	private static CollegeDao instance = null;
	
	private CollegeDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}
	
	public static final CollegeDao getInstance() {
		if(instance == null) {
			instance = new CollegeDaoImpl();
		}
		return instance;
	}
	
	@Override
	public String getColname(int cid) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select cname from college where cid = ?";
		String colname = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			res = pstmt.executeQuery();
			while(res.next()) {
				colname = new String(res.getString("cname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return colname;
	}

	@Override
	public int getColid(String cname) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select cid from college where cname = ?";
		int cid = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			res = pstmt.executeQuery();
			while(res.next()) {
				cid = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return cid;
	}

}
