package cn.service;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.dao.CollegeDao;
import cn.dao.StudentDao;
import cn.dao.TeamDao;
import cn.daoImpl.CollegeDaoImpl;
import cn.daoImpl.StudentDaoImpl;
import cn.daoImpl.TeamDaoImpl;
import cn.model.Student;

public class StudentService {
	
	private StudentDao stdao= null;
	private static StudentService instance= null;
	
	private StudentService() {
		stdao = StudentDaoImpl.getInstance();
	}
	
	public static final StudentService getInstance() {
		if(instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
	
	public boolean deleteStudent(int sid) {
		boolean flag = stdao.deleteStudent(sid);
		return flag;
	}
	
	public boolean checkStudent(int sid, int flag) {
		boolean state = stdao.checkStudent(sid, flag);
		return state;
	}
	
	public Student get_Student(int sid) {
		Student st = null;
		st = stdao.get_Student(sid);
		return st;
	}
	
	public LinkedList<Student> getStudent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LinkedList<Student> list = stdao.getStudent((int) session.getAttribute("teamId"));
		return list;
	}
	
	public LinkedList<Student> getAllStudent() {
		LinkedList<Student> list = stdao.getAllStudent();
		return list;
	}
	
	public LinkedList<Student> getUncheckStudent() {
		LinkedList<Student> list = stdao.getUncheckStudent();
		return list;
	}
	
	public boolean addStudent(HttpServletRequest request) {
		Student std = new Student();
		String sname = request.getParameter("sname");
		String snumber = request.getParameter("snumber");
		String telephone = request.getParameter("telephone");
		String colname = request.getParameter("colname");
		String email = request.getParameter("email");
		try {
			sname = new String(sname.getBytes("8859_1"), "utf-8");
			snumber = new String(snumber.getBytes("8859_1"), "utf-8");
			telephone = new String(telephone.getBytes("8859_1"), "utf-8");
			colname = new String(colname.getBytes("8859_1"), "utf-8");
			email = new String(email.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CollegeDao dao = CollegeDaoImpl.getInstance();
		HttpSession session = request.getSession();
		int cid = dao.getColid(colname);
		std.setSname(sname);
		std.setSnumber(snumber);
		std.setCid(cid);
		std.setTid((int) session.getAttribute("teamId"));
		std.setTelephone(telephone);
		std.setEmail(email);
		boolean flag = stdao.addStudent(std);
		return flag;
	}
}
