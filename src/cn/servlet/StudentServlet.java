package cn.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.model.Student;
import cn.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name="StudentServlet", urlPatterns="/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService instance = StudentService.getInstance();
		String find = request.getParameter("find");
		String check = request.getParameter("check");
		String delete = request.getParameter("delete");
		String modify = request.getParameter("modify");
		
		if(null != modify) {
			int sid = Integer.valueOf(modify);
			Student st = instance.get_Student(sid);
			request.setAttribute("student", st);
			request.getRequestDispatcher("/user/modifyStudent.jsp").forward(request, response);
		}
		if(null != delete) {
			int sid = Integer.valueOf(delete);
			boolean flag = instance.deleteStudent(sid);
			String url = request.getContextPath() + "/StudentServlet?find=2";
			if(flag == true) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(url);
			}
		}
		if(null != check) {
			String id = request.getParameter("sid");
			int sid = Integer.valueOf(id);
			int flag = Integer.valueOf(check);
			boolean state = instance.checkStudent(sid, flag);
			String url = request.getContextPath() + "/StudentServlet?find=3";
			if(state == true) {
				response.sendRedirect(url);
			} else {
				response.sendRedirect(url);
			}
		}
		if(null != find) {
			int flag = Integer.valueOf(find);
			if(flag == 1) {
				LinkedList<Student> list = instance.getStudent(request);
				request.setAttribute("studentlist", list);
				request.getRequestDispatcher("/user/studentList.jsp").forward(request, response);
			} else if(flag == 2) {
				LinkedList<Student> list = instance.getAllStudent();
				request.setAttribute("studentlist", list);
				request.getRequestDispatcher("/admin/studentList.jsp").forward(request, response);
			} else if(flag == 3) {
				LinkedList<Student> list = instance.getUncheckStudent();
				request.setAttribute("studentlist", list);
				request.getRequestDispatcher("/admin/uncheckStudent.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService instance = StudentService.getInstance();
		String modifysid = request.getParameter("modifysid");
		if(null != modifysid) {
			int sid = Integer.valueOf(modifysid);
			instance.deleteStudent(sid);
			instance.addStudent(request);
			String url = request.getContextPath() + "/StudentServlet?find=1";
			response.sendRedirect(url);
			return;
		}
		boolean flag = instance.addStudent(request);
		if(flag == true) {
			request.getRequestDispatcher("/user/addStudent.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/user/addStudent.jsp").forward(request, response);
		}
		
	}

}
