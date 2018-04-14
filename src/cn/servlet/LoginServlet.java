package cn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.StudentDao;
import cn.dao.TeacherDao;
import cn.dao.TeamDao;
import cn.dao.UserDao;
import cn.daoImpl.StudentDaoImpl;
import cn.daoImpl.TeacherDaoImpl;
import cn.daoImpl.TeamDaoImpl;
import cn.daoImpl.UserDaoImpl;
import cn.utils.LoginUtils;
import cn.utils.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String index = request.getParameter("index");
		if(StringUtils.isEmpty(index)) {
			
		} else {
			if(index.equals("1")) {
				TeacherDao tc = TeacherDaoImpl.getInstance();
				StudentDao st = StudentDaoImpl.getInstance();
				int tnumber0 = tc.getTeacherNumber(0);
				int tnumber1 = tc.getTeacherNumber(1);
				int snumber0 = st.getStudentNumber(0);
				int snumber1 = st.getStudentNumber(1);
				request.setAttribute("tnumber0", tnumber0);
				request.setAttribute("tnumber1", tnumber1);
				request.setAttribute("snumber0", snumber0);
				request.setAttribute("snumber1", snumber1);
				//session.setAttribute("username", request.getParameter("username"));
				request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
				return;
			}
		}
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
			request.getRequestDispatcher("/index.html").forward(request, response);
		try {
			username = new String(username.getBytes("8859_1"), "utf-8");
			password = new String(password.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao instance = UserDaoImpl.getInstance();
		int flag = instance.login(username, password);
		if(flag == 0) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		} else if(flag == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("type", "admin");
			TeacherDao tc = TeacherDaoImpl.getInstance();
			StudentDao st = StudentDaoImpl.getInstance();
			int tnumber0 = tc.getTeacherNumber(0);
			int tnumber1 = tc.getTeacherNumber(1);
			int snumber0 = st.getStudentNumber(0);
			int snumber1 = st.getStudentNumber(1);
			request.setAttribute("tnumber0", tnumber0);
			request.setAttribute("tnumber1", tnumber1);
			request.setAttribute("snumber0", snumber0);
			request.setAttribute("snumber1", snumber1);
			//session.setAttribute("username", request.getParameter("username"));
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		} else if(flag == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("type", "team");
			TeamDao team = TeamDaoImpl.getInstance();
			session.setAttribute("teamId", team.getTeamId(username));
			request.getRequestDispatcher("/user/index.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
