<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<h3>Login page</h3>
	<c:out value="${message}" default="" ></c:out>
	<s:form action="loginAction" method="post">
		<s:textfield label="Email" name="user.email"></s:textfield>
		<s:password label="Password " name="user.password"></s:password>
		<s:checkbox label="Remember Me" name="cbRemember"></s:checkbox>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>