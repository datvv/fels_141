<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h3>
		<fmt:message key="logout.out" />
		<s:a action="logoutAction">
			<fmt:message key="logout.click" />
		</s:a>
	</h3>
	<s:a href="wordlistAction">
		<fmt:message key="logout.wordList" />
	</s:a>
</div>