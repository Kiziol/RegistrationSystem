package cn.service;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.dao.StudentDao;
import cn.dao.TeacherDao;
import cn.daoImpl.StudentDaoImpl;
import cn.daoImpl.TeacherDaoImpl;
import cn.model.Student;
import cn.model.Teacher;

public class FileService {
	
	private StudentDao stdao = null;
	private TeacherDao tcdao = null;
	private static FileService instance = null;
	
	private FileService() {
		stdao = StudentDaoImpl.getInstance();
		tcdao = TeacherDaoImpl.getInstance();
	}
	
	public static final FileService getInstance() {
		if(instance == null) {
			instance = new FileService();
		}
		return instance;
	}
	
	public void downloadStudent(HttpServletRequest request, HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			request.setCharacterEncoding("gbk");
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String("学生信息".getBytes("gb2312"), "ISO8859-1") + ".xls");
			out = response.getOutputStream();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("学生信息");
		HSSFRow titleRow = null;
		titleRow = sheet.createRow(0);
		HSSFCell titleCell1 = null;
		sheet.setColumnWidth(4, 5000);
		
		titleCell1 = titleRow.createCell(0);
		titleCell1.setCellValue("序号");
		titleCell1 = titleRow.createCell(1);
		titleCell1.setCellValue("姓名");
		titleCell1 = titleRow.createCell(2);
		titleCell1.setCellValue("学号");
		titleCell1 = titleRow.createCell(3);
		titleCell1.setCellValue("所属学院");
		titleCell1 = titleRow.createCell(4);
		titleCell1.setCellValue("联系电话");
		titleCell1 = titleRow.createCell(5);
		titleCell1.setCellValue("邮箱");
		titleCell1 = titleRow.createCell(6);
		titleCell1.setCellValue("状态");
		
		LinkedList<Student> list = stdao.getAllStudent();
		int row = 0;
		for(Student student:list) {
			titleRow = sheet.createRow(++row);
			titleCell1 = titleRow.createCell(0);
			titleCell1.setCellValue(student.getSid());
			titleCell1 = titleRow.createCell(1);
			titleCell1.setCellValue(student.getSname());
			titleCell1 = titleRow.createCell(2);
			titleCell1.setCellValue(student.getSnumber());
			titleCell1 = titleRow.createCell(3);
			titleCell1.setCellValue(student.getCname());
			titleCell1 = titleRow.createCell(4);
			titleCell1.setCellValue(student.getTelephone());
			titleCell1 = titleRow.createCell(5);
			titleCell1.setCellValue(student.getEmail());
			titleCell1 = titleRow.createCell(6);
			if(student.getState() == 0) {
				titleCell1.setCellValue("未审核");
			} else if(student.getState() == 1) {
				titleCell1.setCellValue("审核通过");
			} else if(student.getState() == 2) {
				titleCell1.setCellValue("审核失败");
			}
			
		}
		
	    try {
			wb.write(out);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                    
	}
	
	public void downloadTeacher(HttpServletRequest request, HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			request.setCharacterEncoding("gbk");
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String("老师信息".getBytes("gb2312"), "ISO8859-1") + ".xls");
			out = response.getOutputStream();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("老师信息");
		HSSFRow titleRow = null;
		titleRow = sheet.createRow(0);
		HSSFCell titleCell1 = null;
		sheet.setColumnWidth(4, 5000);
		
		titleCell1 = titleRow.createCell(0);
		titleCell1.setCellValue("序号");
		titleCell1 = titleRow.createCell(1);
		titleCell1.setCellValue("姓名");
		titleCell1 = titleRow.createCell(2);
		titleCell1.setCellValue("所属学院");
		titleCell1 = titleRow.createCell(3);
		titleCell1.setCellValue("联系电话");
		titleCell1 = titleRow.createCell(4);
		titleCell1.setCellValue("邮箱");
		titleCell1 = titleRow.createCell(5);
		titleCell1.setCellValue("状态");
		
		LinkedList<Teacher> list = tcdao.getAllTeacher();
		int row = 0;
		for(Teacher teacher:list) {
			titleRow = sheet.createRow(++row);
			titleCell1 = titleRow.createCell(0);
			titleCell1.setCellValue(teacher.getTcid());
			titleCell1 = titleRow.createCell(1);
			titleCell1.setCellValue(teacher.getTname());
			titleCell1 = titleRow.createCell(2);
			titleCell1.setCellValue(teacher.getCname());
			titleCell1 = titleRow.createCell(3);
			titleCell1.setCellValue(teacher.getTelephone());
			titleCell1 = titleRow.createCell(4);
			titleCell1.setCellValue(teacher.getEmail());
			titleCell1 = titleRow.createCell(5);
			if(teacher.getState() == 0) {
				titleCell1.setCellValue("未审核");
			} else if(teacher.getState() == 1) {
				titleCell1.setCellValue("审核通过");
			} else if(teacher.getState() == 2) {
				titleCell1.setCellValue("审核失败");
			}
			
		}
		
	    try {
			wb.write(out);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                    
	}
	
}
