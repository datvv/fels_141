<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<div id="wrapperLw">
		<div id="top" align="center">
			<s:form action="filterWordsByCategoryAction" method="post">
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
				<s:submit type="button">
					<s:param name="value">
						<fmt:message key="admin.submit" />
					</s:param>
				</s:submit>
			</s:form>
		</div>
		<div id="body-content" align="center">
			<s:form action="addWordAndAnswerAction" method="POST">
				<s:submit type="button" value="Add Word"></s:submit>
			</s:form>
			<table border="1">
				<tr>
					<th><fmt:message key="admin.stt" /></th>
					<th><fmt:message key="admin.wordName" /></th>
					<th><fmt:message key="admin.wordResult" /></th>
					<th><fmt:message key="admin.update" /></th>
					<th><fmt:message key="admin.delete" /></th>
				</tr>
				<s:iterator value="%{listWordCategory}" var="wordCategory"
					status="rowstatus">
					<tr>
						<td><s:property value="#rowstatus.count" /></td>
						<td><s:property value="#wordCategory.contentWord" /></td>
						<td><s:property value="#wordCategory.contentResult" /></td>
						<td><s:a href="editWordsAction?wordId=%{#wordCategory.wordCategoryId}">
								<fmt:message key="admin.update" />
							</s:a></td>
						<td><s:a href="deleteWordAndAnswer?wordId=%{#wordCategory.wordCategoryId}">
								<fmt:message key="admin.delete" />
							</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</div>