<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="ctxpath" value="${pageContext.request.contextPath}" />       
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>

<sf:form method="post" action="${ctxpath}/user/upload" enctype="multipart/form-data">
<div>上传附件<input type="file" name="attachs"/></div>
<div><input type="submit" value="上传"/></div>
</sf:form>
 <div>
 	<a href="${ctxpath}/user/list">返回</a>
 </div>	
</body>
</html>