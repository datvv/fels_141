<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h2>
		<fmt:message key="admin.addCategory" />
	</h2>
	<s:a href="addCategoryAction">
		<fmt:message key="admin.addCategory" />
	</s:a>
	<h3>
		<fmt:message key="admin.listCategories" />
	</h3>
	<table border="1">
		<tr>
			<th><fmt:message key="admin.stt" /></th>
			<th><fmt:message key="wordList.category" /></th>
			<th><fmt:message key="admin.description" /></th>
			<th><fmt:message key="admin.update" /></th>
			<th><fmt:message key="admin.delete" /></th>
		</tr>
		<s:iterator value="%{listCategory}" var="category" status="rowCount">
			<tr>
				<td><s:property value="#rowCount.count" /></td>
				<td><s:property value="#category.name" /></td>
				<td><s:property value="#category.description" /></td>
				<td>
					<s:a href="categoryUpdateAction?categoryId=%{#category.id}">
						<fmt:message key="admin.update" />
					</s:a>
				</td>
				<td>
					<s:a href="deleteCategoryAction?categoryId=%{#category.id}">
						<fmt:message key="admin.delete" />
					</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
</div>