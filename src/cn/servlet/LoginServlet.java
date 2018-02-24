package cn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dao.TeamDao;
import cn.dao.UserDao;
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
		/*int flag = LoginUtils.login(request, response);
		if(flag == 0) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		} else if(flag == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("type", "admin");
			session.setAttribute("username", request.getParameter("username"));
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		} else if(flag == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("type", "team");
			session.setAttribute("username", request.getParameter("username"));
			request.getRequestDispatcher("/user/index.jsp").forward(request, response);	
		}*/
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
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
