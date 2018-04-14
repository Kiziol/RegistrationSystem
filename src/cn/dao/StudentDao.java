package cn.dao;

import java.util.LinkedList;

import cn.model.Student;

public interface StudentDao {
	public boolean addStudent(Student std);
	public LinkedList<Student> getStudent(int teamId);
	public LinkedList<Student> getAllStudent();
	public LinkedList<Student> getUncheckStudent();
	public boolean checkStudent(int sid, int flag);
	public boolean deleteStudent(int sid);
	public Student get_Student(int sid);
	public int getStudentNumber(int flag);
}
