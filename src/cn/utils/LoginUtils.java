package cn.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.daoImpl.UserDaoImpl;

public class LoginUtils {
	
	public static int login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			return 0;
		try {
			username = new String(username.getBytes("8859_1"), "utf-8");
			password = new String(password.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao instance = UserDaoImpl.getInstance();
		int flag = instance.login(username, password);
		return flag;
	}
}
