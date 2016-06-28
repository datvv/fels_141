<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h2>
	<fmt:message key="admin.updateWords" />
</h2>
<div>
	<form action="editAndSaveAction" method="POST">
		<s:textfield name="wordNeedEdit.content"
			value="%{wordNeedEdit.content}">
			<s:param name="label">
				<fmt:message key="admin.wordContent" />
			</s:param>
		</s:textfield>
		<br />
		<s:iterator value="%{listWordAnswers}" var="wordAnswer"
			status="rowstatus">
			<s:textfield name="listWordAnswers[%{#rowstatus.index}].content"
				value="%{#wordAnswer.content}">
				<s:param name="label">
					<fmt:message key="admin.wordAnswer" />
					<s:property value="#rowstatus.count" />
				</s:param>
			</s:textfield>
			<s:checkbox name="listWordAnswers[%{#rowstatus.index}].correct"
				value="%{#wordAnswer.correct}"></s:checkbox>
			<br />
		</s:iterator>
		<br />
		<s:submit align="left">
			<s:param name="value">
				<fmt:message key="admin.submit" />
			</s:param>
		</s:submit>
	</form>
</div>


