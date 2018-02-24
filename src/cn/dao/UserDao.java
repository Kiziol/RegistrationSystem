package cn.dao;

public interface UserDao {
	
	boolean register(String username, String password, String teamname);
	int login(String username, String password);
}
