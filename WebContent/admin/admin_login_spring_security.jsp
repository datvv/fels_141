<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h1>Struts2 - Spring security - admin login</h1>
	<s:if test="%{#parameters.error != null}">
		<div style="color: red">Invalid User</div>
	</s:if>
	<s:form name="adminLoginForm" action="j_spring_security_check" method="post">
		<s:textfield name="username" label="Username" />
		<s:password name="password" label="Password" />
		<s:submit value="Login" />
	</s:form>
</div>