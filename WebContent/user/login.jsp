<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div>
	<h2>
		<fmt:message key="login.title"></fmt:message>
	</h2>
	<c:out value="${message}" default=""></c:out>
	<br />
	<fmt:message key="login.needAnAccount"></fmt:message>
	<s:a action="signUp">
		<fmt:message key="login.signUp"></fmt:message>
	</s:a>
	<s:form action="loginAction" method="post">
		<s:textfield name="user.email" required="true">
			<s:param name="label">
				<fmt:message key="login.email"></fmt:message>
			</s:param>
		</s:textfield>
		<s:password name="user.password" required="true">
			<s:param name="label">
				<fmt:message key="login.password"></fmt:message>
			</s:param>
		</s:password>
		<s:checkbox name="cbRemember">
			<s:param name="label">
				<fmt:message key="login.rmb"></fmt:message>
			</s:param>
		</s:checkbox>
		<s:submit type="button">
			<s:param name="value">
				<fmt:message key="login.submit"></fmt:message>
			</s:param>
		</s:submit>
	</s:form>
</div>