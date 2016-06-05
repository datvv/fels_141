<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>This is user login page</h3>
	<s:a action="logoutAction">Logout</s:a>
	<br />
	<br />
	<br />

	<s:url id="wordlistAction" action="wordlistAction" var="myurl">
		<s:param name="userid">%{userLogin.user_id}</s:param>
	</s:url>
	Word list to learn: <a href='<s:property value="#myurl"/>'> Click word list <s:property value="" /></a>

</body>
</html>