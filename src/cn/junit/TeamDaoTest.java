package cn.junit;

import org.junit.Test;

import cn.dao.TeacherDao;
import cn.dao.TeamDao;
import cn.daoImpl.TeacherDaoImpl;
import cn.daoImpl.TeamDaoImpl;

public class TeamDaoTest {
	
	@Test
	public void getTeamIdTest() {
		TeamDao team = TeamDaoImpl.getInstance();
		//System.out.println(team.getTeamId("1"));
	}
	
	@Test
	public void test() {
		TeacherDao tc  = TeacherDaoImpl.getInstance();
		tc.getTeacherNumber(0);
	}
}
