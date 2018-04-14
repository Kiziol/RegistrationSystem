<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/leftStyle.css" />
	</head>
	
		<div class="wrap">
		
			<c:if test="${sessionScope.type == 'team'}">
			
				<div class='card'>
				    <a href='${pageContext.request.contextPath }/LoginServlet?index=2'>
				      <div class='bg-01'>
				    	<span class='content'>首页</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/user/addStudent.jsp'>
				      <div class='bg-02'>
				    	<span class='content'>添加队员</span>
				      </div>
				    </a>
		  		</div>

			  	<div class='card'>
			  		<a href='${pageContext.request.contextPath }/StudentServlet?find=1'>
				      <div class='bg-03'>
				    	<span class='content'>队员列表</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/user/addTeacher.jsp'>
				      <div class='bg-04'>
				    	<span class='content'>添加指导老师</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/TeacherServlet?find=1'>
				      <div class='bg-05'>
				    	<span class='content'>指导老师列表</span>
				      </div>
				    </a>
			  	</div>
			  	
				<div class='card'>
				    <a href='#'>
				      <div class='bg-06'>
				    	<span class='content'>选题</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='#'>
				      <div class='bg-07'>
				    	<span class='content'>作品提交</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/QuitServlet'>
				      <div class='bg-00'>
				    	<span class='content'>安全退出</span>
				      </div>
				    </a>
			  	</div>
			</c:if>

          	<c:if test="${sessionScope.type == 'admin'}">
      			<div class='card'>
				    <a href='${pageContext.request.contextPath }/LoginServlet?index=1'>
				      <div class='bg-01'>
				    	<span class='content'>首页</span>
				      </div>
				    </a>
			  	</div>    	
          	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/StudentServlet?find=3'>
				      <div class='bg-02'>
				    	<span class='content'>待审核学生</span>
				      </div>
				    </a>
			  	</div>
	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/TeacherServlet?find=3'>
				      <div class='bg-03'>
				    	<span class='content'>待审核老师</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
			  		<a href='${pageContext.request.contextPath }/StudentServlet?find=2'>
				      <div class='bg-04'>
				    	<span class='content'>学生列表</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/TeacherServlet?find=2'>
				      <div class='bg-05'>
				    	<span class='content'>老师列表</span>
				      </div>
				    </a>
			  	</div>
			  	
				<div class='card'>
				    <a href='#'>
				      <div class='bg-06'>
				    	<span class='content'>选题设置</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='#'>
				      <div class='bg-07'>
				    	<span class='content'>作品查看</span>
				      </div>
				    </a>
			  	</div>
			  	
			  	<div class='card'>
				    <a href='${pageContext.request.contextPath }/QuitServlet'>
				      <div class='bg-00'>
				    	<span class='content'>安全退出</span>
				      </div>
				    </a>
			  	</div>
			 </c:if>
		  	
		</div>
	
</html>