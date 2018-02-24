package cn.junit;

import org.junit.Test;

import cn.dao.UserDao;
import cn.daoImpl.UserDaoImpl;

public class UserDaoTest {
	
	@Test
	public void registerTest() {
		UserDao userDao = UserDaoImpl.getInstance();
		userDao.register("123", "123", "123");
	}
	
	
}
