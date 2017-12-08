<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
<title>My JSP 'add.jsp' starting page</title>

</head>

<body>
	<fm:form method="post" modelAttribute="user">
		<fm:errors path="userCode" /> <br/>
  	用户编码:<fm:input path="userCode" />
		<br />
		<fm:errors path="userName" />
		<br />
  	用户名称:<fm:input path="userName" />
		<br />
		<fm:errors path="userPassword" />
		<br />
  	用户密码:<fm:password path="userPassword" />
		<br />
		<fm:errors path="birthday" />
		<br />
  	用户生日:<fm:input path="birthday" Class="Wdate" onclick="WdatePicker();"
			readonly="readonly" />
		<br />
  	用户地址:<fm:input path="address" />
		<br />
  	联系电话:<fm:input path="phone" />
		<br />
  	用户角色:<fm:radiobutton path="userRole" value="1" />系统管理员
  	<fm:radiobutton path="userRole" value="2" />经理
  	<fm:radiobutton path="userRole" value="3" checked="checked" />普通用户
  	<br />
		<input type="submit" value="保存" />
	</fm:form>
</body>
</html>
