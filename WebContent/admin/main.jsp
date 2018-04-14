<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	
		<h1 style="margin-top: 100px;margin-left: 400px;color: #FF5511 ;">欢迎进入浙江XX大学报名系统</h1>
		<table style="margin-top: 150px;margin-left: 400px;">
			<tr >
				<th style="padding: 15px;">大赛进行阶段</th>
				<td style="color: #EE7700 ;">报名阶段</td>
			</tr>
			<tr>
				<th style="padding: 15px;">队员审核情况</th>
				<td>${snumber1 }位学生通过审核，${snumber0 }位学生等待审核！</td>
			</tr>
			<tr>
				<th style="padding: 15px;">老师审核情况</th>
				<td>${tnumber1 }位指导老师通过审核，${tnumber0 }位指导老师等待审核！</td>
			</tr>
		</table>
	
</html>