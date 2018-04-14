package cn.dao;

import java.util.LinkedList;

import cn.model.Teacher;

public interface TeacherDao {
	public boolean addStudent(Teacher tc);
	public LinkedList<Teacher> getTeacher(int teamId);
	public LinkedList<Teacher> getAllTeacher();
	public LinkedList<Teacher> getUncheckTeacher();
	public boolean checkTeacher(int tcid, int flag);
	public boolean deleteTeacher(int tcid);
	public Teacher get_Teacher(int tcid);
	public int getTeacherNumber(int flag);
	public int getTeacherNumber(int teamId, int flag);
}
