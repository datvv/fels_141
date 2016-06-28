<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h2>
		<fmt:message key="admin.addWords" />
	</h2>
	<s:form action="addAndSaveWords" method="POST">
		<s:select id="selectedCategory" name="selectedCategory"
			list="listCategory" listKey="name" listValue="name">
			<s:param name="label">
				<fmt:message key="wordList.category" />
			</s:param>
			<s:param name="headerKey">
			</s:param>
			<s:param name="headerValue">
				<fmt:message key="wordList.selectCategory" />
			</s:param>
		</s:select>
		<s:textfield name="wordNeedEdit.content">
			<s:param name="label">
				<fmt:message key="admin.wordContent" />
			</s:param>
		</s:textfield>
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
		<s:submit>
			<s:param name="value">
				<fmt:message key="admin.submit" />
			</s:param>
		</s:submit>
	</s:form>
</div>