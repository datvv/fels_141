<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h3>
		<fmt:message key="admin.updateUser" />
	</h3>
	<s:form action="updateAndSaveAction" method="POST">
		<s:hidden name="userUpdate.id"></s:hidden>
		<s:textfield name="userUpdate.username">
			<s:param name="label">
				<fmt:message key="admin.userName" />
			</s:param>
		</s:textfield>
		<s:textfield name="userUpdate.email">
			<s:param name="label">
				<fmt:message key="login.email" />
			</s:param>
		</s:textfield>
		<s:textfield name="userUpdate.avatar">
			<s:param name="label">
				<fmt:message key="admin.avatar" />
			</s:param>
		</s:textfield>
		<s:checkbox name="userUpdate.isAdmin">
			<s:param name="label">
				<fmt:message key="admin.isAdmin" />
			</s:param>
		</s:checkbox>
		<s:submit>
			<s:param name="value">
				<fmt:message key="admin.submit" />
			</s:param>
		</s:submit>
	</s:form>
</div>