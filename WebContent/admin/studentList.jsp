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
	<h1 style="margin-top: 100px;margin-left: 400px;color: #FF5511 ;">队员列表</h1>
	<table style="margin-top: 150px;margin-left: 400px;" cellpadding="0" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>学号</th>
			<th>所属学院</th>
			<th>联系电话</th>
			<th>邮箱</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${studentlist}" var="list">
			<tr>
				<td>${list.sid }</td>
				<td>${list.sname }</td>
				<td>${list.snumber }</td>
				<td>${list.cname }</td>
				<td>${list.telephone }</td>
				<td>${list.email }</td>
			<c:if test="${list.state == 0}">
				<td style="color:#FF0000 ">未审核</td>
			</c:if>
			<c:if test="${list.state == 1}">
				<td>审核通过</td>
			</c:if>
			<c:if test="${list.state == 2}">
				<td>审核失败</td>
			</c:if>
				<td> 
					<a href="${pageContext.request.contextPath }/StudentServlet?delete=${list.sid }" class="operation" style="color:#00BBFF; text-decoration:none;">删除</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>