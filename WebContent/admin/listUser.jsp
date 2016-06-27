<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h3>
		<th><fmt:message key="admin.manageUserPage" /></th>
	</h3>
	<table border="1">
		<tr>
			<th><fmt:message key="admin.stt" /></th>
			<th><fmt:message key="admin.userName" /></th>
			<th><fmt:message key="login.email" /></th>
			<th><fmt:message key="admin.updateUser" /></th>
			<th><fmt:message key="admin.deleteUser" /></th>
		</tr>
		<s:iterator value="%{listUser}" var="user" status="rowCount">
			<tr>
				<td><s:property value="#rowCount.count" /></td>
				<td><s:property value="#user.username" /></td>
				<td><s:property value="#user.email" /></td>
				<td><s:a href="userUpdateAction?userId=%{#user.id}">
						<fmt:message key="admin.update" />
					</s:a></td>
				<td><s:a href="deleteUserAction?userId=%{#user.id}">
						<fmt:message key="admin.delete" />
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
</div>