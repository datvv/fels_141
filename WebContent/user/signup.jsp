<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<s:form action="signUp" method="post" enctype="multipart/form-data">
		<s:textfield name="user.email">
			<s:param name="label">
				<fmt:message key="msg.email" />
			</s:param>
		</s:textfield>
		<s:textfield name="user.username">
			<s:param name="label">
				<fmt:message key="msg.username" />
			</s:param>
		</s:textfield>
		<s:password name="user.password">
			<s:param name="label">
				<fmt:message key="msg.password" />
			</s:param>
		</s:password>
		<s:password name="passwordConfirm">
			<s:param name="label">
				<fmt:message key="msg.confirmpassword" />
			</s:param>
		</s:password>
		<s:submit value="Sign Up" align="center" />
	</s:form>
</div>
