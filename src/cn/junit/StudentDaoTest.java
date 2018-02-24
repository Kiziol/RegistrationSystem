package cn.junit;

import org.junit.Test;

import cn.dao.StudentDao;
import cn.daoImpl.StudentDaoImpl;
import cn.service.StudentService;

public class StudentDaoTest {
	
	@Test
	public void getStudentTest() {
		StudentDao instance = StudentDaoImpl.getInstance();
		instance.getStudent(15);
	}
}
