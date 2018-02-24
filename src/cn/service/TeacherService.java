package cn.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.dao.CollegeDao;
import cn.dao.TeacherDao;
import cn.daoImpl.CollegeDaoImpl;
import cn.daoImpl.TeacherDaoImpl;
import cn.model.Teacher;


public class TeacherService {
	
	private TeacherDao tcdao = null;
	private static TeacherService instance = null;
	
	private TeacherService() {
		tcdao = TeacherDaoImpl.getInstance();
	}
	
	public static final TeacherService getInstance() {
		if(instance == null) {
			instance = new TeacherService();
		}
		return instance;
	}
	
	public Teacher get_Teacher(int tcid) {
		Teacher tc = tcdao.get_Teacher(tcid);
		return tc;
	}
	
	public boolean deleteTeacher(int tcid) {
		boolean flag = tcdao.deleteTeacher(tcid);
		return flag;
	}
	
	public boolean checkTeacher(int tcid, int flag) {
		boolean state = tcdao.checkTeacher(tcid, flag);
		return state;
	}
	
	public boolean addTeacher(HttpServletRequest request) {
		Teacher tc = new Teacher();
		String tname = request.getParameter("tname");
		String telephone = request.getParameter("telephone");
		String colname = request.getParameter("colname");
		String email = request.getParameter("email");
		try {
			tname = new String(tname.getBytes("8859_1"), "utf-8");
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
		tc.setTname(tname);
		tc.setTelephone(telephone);
		tc.setCid(cid);
		tc.setTid((int) session.getAttribute("teamId"));
		tc.setEmail(email);
		boolean flag = tcdao.addStudent(tc);
		return flag;
	}
	
	public LinkedList<Teacher> getUncheckTeacher() {
		LinkedList<Teacher> list = tcdao.getUncheckTeacher();
		return list;
	}
	
	public LinkedList<Teacher> getTeacher(HttpServletRequest request) {
		HttpSession session = request.getSession();
		LinkedList<Teacher> list = tcdao.getTeacher((int) session.getAttribute("teamId"));
		return list;
	}
	
	public LinkedList<Teacher> getAllTeacher() {
		LinkedList<Teacher> list = tcdao.getAllTeacher();
		return list;
	}
}
