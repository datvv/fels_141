<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en" />
<fmt:setBundle basename="msg" var="lang" />
<div>
	<h2>
		<fmt:message key="login.title" bundle="${lang}"></fmt:message>
	</h2>
	<c:out value="${message}" default=""></c:out>
	<br />
	<fmt:message key="login.needAnAccount" bundle="${lang}"></fmt:message>
	<s:a action="signUp">
		<fmt:message key="login.signUp" bundle="${lang}"></fmt:message>
	</s:a>
	<s:form action="loginAction" method="post">
		<s:textfield name="user.email" required="true">
			<s:param name="label">
				<fmt:message key="login.email" bundle="${lang}"></fmt:message>
			</s:param>
		</s:textfield>
		<s:password name="user.password" required="true">
			<s:param name="label">
				<fmt:message key="login.password" bundle="${lang}"></fmt:message>
			</s:param>
		</s:password>
		<s:checkbox name="cbRemember">
			<s:param name="label">
				<fmt:message key="login.rmb" bundle="${lang}"></fmt:message>
			</s:param>
		</s:checkbox>
		<s:submit type="button" >
			<s:param name="value">
				<fmt:message key="login.submit" bundle="${lang}"></fmt:message>
			</s:param>
		</s:submit>
	</s:form>
</div>