package cn.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.dao.CollegeDao;
import cn.dao.StudentDao;
import cn.db.C3P0Connection;
import cn.model.Student;
import cn.utils.DBUtils;

public class StudentDaoImpl implements StudentDao {
	
	private Connection conn = null;
	private static StudentDao instance = null;
	
	private StudentDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}
	
	public static final StudentDao getInstance() {
		if(instance == null) {
			instance = new StudentDaoImpl();
		}
		return instance;
	}
	
	@Override
	public boolean addStudent(Student std) {
		PreparedStatement pstmt = null;
		int flag = 0;
		String sql = "insert into student(sname, snumber, cid, tid, telephone, email) values (?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getSname());
			pstmt.setString(2, std.getSnumber());
			pstmt.setInt(3, std.getCid());
			pstmt.setInt(4, std.getTid());
			pstmt.setString(5, std.getTelephone());
			pstmt.setString(6, std.getEmail());
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
	public LinkedList<Student> getStudent(int teamId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from student where tid = ?";
		List<Student> list = new LinkedList<Student>();
		CollegeDao cldao = CollegeDaoImpl.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teamId);
			res = pstmt.executeQuery();
			while(res.next()) {
				Student st = new Student();
				st.setSid(res.getInt(1));
				st.setSname(res.getString("sname"));
				st.setSnumber(res.getString("snumber"));
				st.setCid(res.getInt(4));
				st.setCname(cldao.getColname(st.getCid()));
				st.setTid(res.getInt(5));
				st.setTelephone(res.getString("telephone"));
				st.setEmail(res.getString("email"));
				st.setState(res.getInt(8));
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Student>) list;
	}

	@Override
	public LinkedList<Student> getAllStudent() {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from student";
		List<Student> list = new LinkedList<Student>();
		CollegeDao cldao = CollegeDaoImpl.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			res = pstmt.executeQuery();
			while(res.next()) {
				Student st = new Student();
				st.setSid(res.getInt(1));
				st.setSname(res.getString("sname"));
				st.setSnumber(res.getString("snumber"));
				st.setCid(res.getInt(4));
				st.setCname(cldao.getColname(st.getCid()));
				st.setTid(res.getInt(5));
				st.setTelephone(res.getString("telephone"));
				st.setEmail(res.getString("email"));
				st.setState(res.getInt(8));
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Student>) list;
	}

	@Override
	public LinkedList<Student> getUncheckStudent() {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from student where state = ?";
		List<Student> list = new LinkedList<Student>();
		CollegeDao cldao = CollegeDaoImpl.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			res = pstmt.executeQuery();
			while(res.next()) {
				Student st = new Student();
				st.setSid(res.getInt(1));
				st.setSname(res.getString("sname"));
				st.setSnumber(res.getString("snumber"));
				st.setCid(res.getInt(4));
				st.setCname(cldao.getColname(st.getCid()));
				st.setTid(res.getInt(5));
				st.setTelephone(res.getString("telephone"));
				st.setEmail(res.getString("email"));
				st.setState(res.getInt(8));
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return (LinkedList<Student>) list;
	}

	@Override
	public boolean checkStudent(int sid, int flag) {
		PreparedStatement pstmt = null;
		String sql = "update student set state = ? where sid = ?";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(flag == 1) {
				pstmt.setInt(1, 1);
			} else if(flag == 2) {
				pstmt.setInt(1, 2);
			} 
			pstmt.setInt(2, sid);
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
	public boolean deleteStudent(int sid) {
		PreparedStatement pstmt = null;
		String sql = "delete from student where sid = ?";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
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
	public Student get_Student(int sid) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String sql = "select * from student where sid = ?";
		Student st = null;
		CollegeDao cldao = CollegeDaoImpl.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			res = pstmt.executeQuery();
			while(res.next()) {
				st = new Student();
				st.setSid(res.getInt(1));
				st.setSname(res.getString("sname"));
				st.setSnumber(res.getString("snumber"));
				st.setCid(res.getInt(4));
				st.setCname(cldao.getColname(st.getCid()));
				st.setTid(res.getInt(5));
				st.setTelephone(res.getString("telephone"));
				st.setEmail(res.getString("email"));
				st.setState(res.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(pstmt, res);
		}
		return st;
	}

}
