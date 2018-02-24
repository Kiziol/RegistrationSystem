<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		form {
			margin-left: 400px;
			margin-top: 50px;
			font-size: 25px;
		}
		._input {
			outline:none;
			height: 35px;
			border-radius:30px;
			font-size: 25px;
			color: #AAAAAA;
			text-align: center;
		}
	</style>
</head>
	<body>
		<jsp:include page="../page/left.jsp"></jsp:include>
		<h1 style="margin-top: 100px;margin-left: 600px;color: #FF5511 ;">添加队员</h1>
		<h2 style="margin-top: 30px;margin-left: 600px;color: #FF0000 ;">所有资料均需填写！</h2>
		<form action="${pageContext.request.contextPath }/StudentServlet" method="post" >
			<table style="margin-left: 100px">
				
			<tr >
				<th style="padding: 15px;">姓名</th>
				<td style="color: #EE7700 ;">
					<input type="text" name="sname" class="_input"/>
				</td>
			</tr>
			
			<tr>
				<th style="padding: 15px;">学号</th>
				<td style="color: #EE7700 ;">
					<input type="text" name="snumber" class="_input"/>
				</td>
			</tr>
			
			<tr>
				<th style="padding: 15px;">联系电话</th>
				<td style="color: #EE7700 ;">
					<input type="text" name="telephone" class="_input"/>
				</td>
			</tr>
			
			<tr>
				<th style="padding: 15px;">所在学院</th>
				<td style="color: #EE7700 ;">
					<select class="_input" name="colname">
						<option value="农业与食品科学学院">农业与食品科学学院</option>
						<option value="环境与资源学院">环境与资源学院</option>
						<option value="风景园林与建筑学院、旅游与健康学院">风景园林与建筑学院、旅游与健康学院</option>
						<option value="动物科技学院">动物科技学院</option>
						<option value="法政学院">法政学院</option>
						<option value="信息工程学院">信息工程学院</option>
						<option value="理学院">理学院</option>
						<option value="国际教育学院">国际教育学院</option>
						<option value="林业与生物技术学院">林业与生物技术学院</option>
						<option value="工程学院">工程学院</option>
						<option value="经济管理学院">经济管理学院</option>
						<option value="马克思主义学院">马克思主义学院</option>
						<option value="艺术设计学院、人文·茶文华学院">艺术设计学院、人文·茶文华学院</option>
						<option value="外国学院">外国学院</option>
						<option value="集贤学院">集贤学院</option>
						<option value="继续教育学院">继续教育学院</option>
					</select>
				</td>
			</tr>
			<tr>
				<th style="padding: 15px;">邮箱</th>
				<td style="color: #EE7700 ;">
					<input type="text" name="email" class="_input"/>
				</td>
			</tr>
			<tr>
				<th style="padding: 15px;">操作</th>
				<td style="color: #EE7700 ;">
					<input type="submit" class="_input" value="提交"/>
				</td>
			</tr>
			</table>
		</form>
	</body>
</html>