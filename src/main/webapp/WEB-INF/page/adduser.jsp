<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<!-- html表单 -->
	<!-- <form action="page.html" method="post">
		姓名:<input type="text" name="name" /><br/>
		年龄:<input type="text" name="age" />
		<input type="submit">
	</form> -->
<!-- spring mvc的表单  可以默认显示从controller中 设置的user中的属性值-->
<form:form action="page.html" method="post" modelAttribute="user">
	姓名:<form:input  path="name" /><br/>
	年龄:<form:input  path="age" /><br/>
	<input type="submit">
</form:form>

</body>
</html>