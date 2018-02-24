package cn.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.model.Teacher;
import cn.service.TeacherService;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet(name="TeacherServlet", urlPatterns="/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherService instance = TeacherService.getInstance();
		String find = request.getParameter("find");
		String check = request.getParameter("check");
		String delete = request.getParameter("delete");
		String modify = request.getParameter("modify");
		
		if(null != modify) {
			int tcid = Integer.valueOf(modify);
			Teacher tc = instance.get_Teacher(tcid);
			request.setAttribute("teacher", tc);
			request.getRequestDispatcher("/user/modifyTeacher.jsp").forward(request, response);
		}
		if(null != delete) {
			int tcid = Integer.valueOf(delete);
			boolean flag = instance.deleteTeacher(tcid);
			String url = request.getContextPath() + "/TeacherServlet?find=2";
			if(flag == true) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(url);
			}
		}
		if(null != check) {
			String id = request.getParameter("tcid");
			int tcid = Integer.valueOf(id);
			int flag = Integer.valueOf(check);
			boolean state = instance.checkTeacher(tcid, flag);
			String url = request.getContextPath() + "/TeacherServlet?find=3";
			if(state == true) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(url);
			}
			//request.getRequestDispatcher("/admin/uncheckTeacher.jsp").forward(request, response);
		}
		if(null != find) {
			int flag = Integer.valueOf(find);
			if(flag == 1) {
				LinkedList<Teacher> list = instance.getTeacher(request);
				request.setAttribute("teacherlist", list);
				request.getRequestDispatcher("/user/teacherList.jsp").forward(request, response);
			} else if(flag == 2) {
				LinkedList<Teacher> list = instance.getAllTeacher();
				request.setAttribute("teacherlist", list);
				request.getRequestDispatcher("/admin/teacherList.jsp").forward(request, response);
			} else if(flag == 3) {
				LinkedList<Teacher> list = instance.getUncheckTeacher();
				request.setAttribute("teacherlist", list);
				request.getRequestDispatcher("/admin/uncheckTeacher.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherService instance = TeacherService.getInstance();
		String modifytcid = request.getParameter("modifytcid");
		if(null != modifytcid) {
			int tcid = Integer.valueOf(modifytcid);
			instance.deleteTeacher(tcid);
			instance.addTeacher(request);
			String url = request.getContextPath() + "/TeacherServlet?find=1";
			response.sendRedirect(url);
			return;
		}
		boolean flag = instance.addTeacher(request);
		if(flag == true) {
			request.getRequestDispatcher("/user/addTeacher.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/user/addTeacher.jsp").forward(request, response);
		}
	}

}
