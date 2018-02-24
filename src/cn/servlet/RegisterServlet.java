package cn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.daoImpl.UserDaoImpl;
import cn.utils.RegisterUtils;
import cn.utils.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*boolean flag = RegisterUtils.register(request, response);
		if(flag == true) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/register.html").forward(request, response);
		}*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String teamname = request.getParameter("teamname");
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(teamname))
			request.getRequestDispatcher("/register.html").forward(request, response);
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
		if(flag == true) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/register.html").forward(request, response);
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
