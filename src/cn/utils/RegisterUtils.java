package cn.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.daoImpl.UserDaoImpl;

public class RegisterUtils {
	
	public static boolean register(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String teamname = request.getParameter("teamname");
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(teamname))
			return false;
		try {
			username = new String(username.getBytes("8859_1"), "utf-8");
			password = new String(password.getBytes("8859_1"), "utf-8");
			teamname = new String(teamname.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao instance = UserDaoImpl.getInstance();
		boolean flag = instance.register(username, password, teamname);
		return flag;
	}
}
