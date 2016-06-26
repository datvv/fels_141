<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h2>
		<fmt:message key="admin.updateCategory" />
	</h2>
	<s:form action="addAndSaveCategoryAction" method="POST">
		<s:textfield name="category.name">
			<s:param name="label">
				<fmt:message key="admin.categoryName" />
			</s:param>
		</s:textfield>
		<s:textfield name="category.description">
			<s:param name="label">
				<fmt:message key="admin.description" />
			</s:param>
		</s:textfield>
		<s:submit>
			<s:param name="value">
				<fmt:message key="admin.submit" />
			</s:param>
		</s:submit>
	</s:form>
</div>