<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en" />
<fmt:setBundle basename="msg" var="lang" />
<div>
	<h3>
		<fmt:message key="logout.out" bundle="${lang}"/>
		<s:a action="logoutAction">
			<fmt:message key="logout.click" bundle="${lang}"/>
		</s:a>
	</h3>
	<s:a href="wordlistAction">
		<fmt:message key="logout.wordList" bundle="${lang}"/>
	</s:a>
</div>