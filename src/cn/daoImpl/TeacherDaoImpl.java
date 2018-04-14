package cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.dao.CollegeDao;
import cn.dao.TeacherDao;
import cn.db.C3P0Connection;
import cn.model.Teacher;
import cn.utils.DBUtils;

public class TeacherDaoImpl implements TeacherDao {
	
	private Connection conn = null;
	private static TeacherDao instance = null;
	
	private TeacherDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}
	
	public static final TeacherDao getInstance() {
		if(instance == null) {
			instance = new TeacherDaoImpl();
		}
		return instance;
	}

	@Override
	public boolean addStudent(Teacher tc) {
		PreparedStatement pstmt = null;
		int flag = 0;
		String sql = "insert into teacher(tname, cid, tid, telephone, email) values (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tc.getTname());
			pstmt.setInt(2, tc.getCid());
			pstmt.setInt(3, tc.getTid());
			pstmt.setString(4, tc.getTelephone());
			pstmt.setString(5, tc.getEmail());
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
	public LinkedList<Teacher> getTeacher(int teamId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from teacher t, college c where (t.cid = c.cid) and tid = ?";
		List<Teacher> list = new LinkedList<Teacher>();
		CollegeDao cldao = CollegeDaoImpl.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teamId);
			res = pstmt.executeQuery();
			while(res.next()) {
				Teacher tc = new Teacher();
				tc.setTcid(res.getInt(1));
				tc.setTname(res.getString("tname"));
				tc.setCid(res.getInt(3));
				tc.setCname(res.getString("cname"));
				tc.setTid(res.getInt(4));
				tc.setTelephone(res.getString("telephone"));
				tc.setEmail(res.getString("email"));
				tc.setState(res.getInt(7));
				list.add(tc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Teacher>) list;
	}

	@Override
	public LinkedList<Teacher> getAllTeacher() {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from teacher t, college c where (t.cid = c.cid)";
		List<Teacher> list = new LinkedList<Teacher>();
		try {
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			while(res.next()) {
				Teacher tc = new Teacher();
				tc.setTcid(res.getInt(1));
				tc.setTname(res.getString("tname"));
				tc.setCid(res.getInt(3));
				tc.setCname(res.getString("cname"));
				tc.setTid(res.getInt(4));
				tc.setTelephone(res.getString("telephone"));
				tc.setEmail(res.getString("email"));
				tc.setState(res.getInt(7));
				list.add(tc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Teacher>) list;
	}

	@Override
	public LinkedList<Teacher> getUncheckTeacher() {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from teacher t, college c where (t.cid = c.cid) and state = ?";
		List<Teacher> list = new LinkedList<Teacher>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			res = pstmt.executeQuery();
			while(res.next()) {
				Teacher tc = new Teacher();
				tc.setTcid(res.getInt(1));
				tc.setTname(res.getString("tname"));
				tc.setCid(res.getInt(3));
				tc.setCname(res.getString("cname"));
				tc.setTid(res.getInt(4));
				tc.setTelephone(res.getString("telephone"));
				tc.setEmail(res.getString("email"));
				tc.setState(res.getInt(7));
				list.add(tc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Teacher>) list;
	}

	@Override
	public boolean checkTeacher(int tcid, int flag) {
		PreparedStatement pstmt = null;
		String sql = "update teacher set state = ? where tcid = ?";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(flag == 1) {
				pstmt.setInt(1, 1);
			} else if(flag == 2) {
				pstmt.setInt(1, 2);
			}
			pstmt.setInt(2, tcid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt);
		}
		if(i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteTeacher(int tcid) {
		PreparedStatement pstmt = null;
		int i = 0;
		String sql = "delete from teacher where tcid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt);
		}
		if(i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Teacher get_Teacher(int tcid) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from teacher t, college c where (t.cid = c.cid) and tcid = ?";
		Teacher tc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcid);
			res = pstmt.executeQuery();
			while(res.next()) {
				tc = new Teacher();
				tc.setTcid(res.getInt(1));
				tc.setTname(res.getString("tname"));
				tc.setCid(res.getInt(3));
				tc.setCname(res.getString("cname"));
				tc.setTid(res.getInt(4));
				tc.setTelephone(res.getString("telephone"));
				tc.setEmail(res.getString("email"));
				tc.setState(res.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return tc;
	}

	@Override
	public int getTeacherNumber(int flag) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select count(*) from teacher where state = ?";
		int number = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(flag == 0) {
				pstmt.setInt(1, 0);
			} else if(flag == 1) {
				pstmt.setInt(1, 1);
			}
			res = pstmt.executeQuery();
			while(res.next()) {
				number = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public int getTeacherNumber(int teamId, int flag) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select count(*) from teacher where state = ? and tid = ?";
		int number = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(flag == 0) {
				pstmt.setInt(1, 0);
				pstmt.setInt(2, teamId);
			} else if(flag == 1) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, teamId);
			}
			res = pstmt.executeQuery();
			while(res.next()) {
				number = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
}
