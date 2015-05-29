<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="ctxpath" value="${pageContext.request.contextPath}" />       
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
</head>
<body>

<sf:form method="post" modelAttribute="user">
<table>
	<tr>
		<td>用户名</td>
		<td>
			<sf:input path="username"/>
		</td>
		<td>
			<sf:errors path="username"/>
		</td>
	</tr>
	<tr>
		<td>别名</td>
		<td>
			<sf:input path="nickname"/>
		</td>
		<td>
			<sf:errors path="nickname"/>
		</td>
	</tr>
	<tr>
		<td>密码</td>
		<td>
		   <sf:password path="password"/>
		</td>
		<td>
			<sf:errors path="password"/>
		</td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td>
			<sf:input path="email"/>
		</td>
		<td>
			<sf:errors path="email"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="提交"/>
		</td>
		<td>
			<input type="reset" value="重置"/>
		</td>
	
	</tr>
</table>
</sf:form>
 	<div>
	 	<a href="${ctxpath}/user/list">返回</a>
	 </div>
</body>
</html>