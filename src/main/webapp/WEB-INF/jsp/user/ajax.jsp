<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctxpath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctxpath}/resources/jquery/jquery-1.9.1.min.js"></script>
<title>ajax提交</title>

<script type="text/javascript">
	var ctxpath = "${ctxpath}";
	
	function postRequest() {
		var username=$("#postContent").val();
		$.ajax({
			type : "post",
			url : ctxpath+"/user/ajax",
			data:{
				username:username,
			},
			beforeSend : function(XMLHttpRequest) {
			},
			success : function(data,textStatus){
				$("#responseContent").val(data);
			},
			complete : function(XMLHttpRequest, textStatus) {
			},
			error : function() {
			}
		});
	}
</script>
</head>
<body>
	<H4>Ajax In  SpringMVC</H4>
	Your Name?
	<div>
		<textarea name="postContent" id="postContent"></textarea>
	</div>
	输出：
	<div>
		<textarea name="responseContent" id="responseContent"></textarea>
	</div>
	
	<div>
		<input type="button" value="发送请求" onclick="postRequest()" />
	</div>

	 <div>
	 	<a href="${ctxpath}/user/list">返回</a>
	 </div>
</body>
</html>