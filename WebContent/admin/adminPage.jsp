<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="wrapper">
	<div id="topAdmin">
		<p><fmt:message key="admin.title" /></p>
	</div>
	<div id="body-content">
		<s:a action="showListUser">
			<fmt:message key="admin.manageUser" />
		</s:a>
		<s:a action="manageCategoryAcion">
			<fmt:message key="admin.manageCategory" />
		</s:a>
		<s:a action="listWordsAction">
			<fmt:message key="admin.manageWord" />
		</s:a>
	</div>
</div>
