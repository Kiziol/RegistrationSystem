<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/listStyle.css" />
</head>
<body>
	<jsp:include page="../page/left.jsp"></jsp:include>
	<h1 style="margin-top: 100px;margin-left: 400px;color: #FF5511 ;">待审核老师</h1>
	<table style="margin-top: 150px;margin-left: 400px;" cellpadding="0" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>所属学院</th>
			<th>联系电话</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${teacherlist}" var="list">
			<tr>
				<td>${list.tcid }</td>
				<td>${list.tname }</td>
				<td>${list.cname }</td>
				<td>${list.telephone }</td>
				<td>${list.email }</td>
				<td>
					<a href="${pageContext.request.contextPath }/TeacherServlet?check=1&tcid=${list.tcid }" class="operation" style="color:#00BBFF; text-decoration:none;">通过</a>|
					<a href="${pageContext.request.contextPath }/TeacherServlet?check=2&tcid=${list.tcid }" class="operation" style="color:#00BBFF; text-decoration:none;">失败</a> 
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>