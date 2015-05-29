<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctxpath}/resources/css/main.css" type="text/css">
<title>用户列表</title>
</head>
<h3>SPRING MVC 演示示例-用户列表</h3>
<body>
	 <div>
	 	<a href="${ctxpath}/user/add">新增用户</a>
	 	<a href="${ctxpath}/user/upload">上传文档</a>
	 	<a href="${ctxpath}/user/ajax">Ajax提交</a>
	 </div>
	 <br>
	<table>
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>别名</td>
			<td>密码</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.value.username}</td>
				<td>${user.value.nickname}</td>
				<td>${user.value.password}</td>
				<td>${user.value.email}</td>
				<td><a href="${user.value.username}/update">修改</a>
				    <a href="${user.value.username }/delete">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div>
		使用技术：Maven+Spring MVC +Hibernate Validate(服务端验证)	
	
	</div>
</body>
</html>

<%--
用  ${stauts.count}   //用stauts.count是从1开始
用  ${stauts.index}   //用stauts.index是从0开始，
--%>