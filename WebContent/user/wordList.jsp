<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<div id="wrapper" style="padding-top: 50px">
		<div id="top" align="center">
			<s:form action="filterAction" method="post">
				<s:select id="selectedCategory" name="selectedCategory" list="listCategory" listKey="name"
					listValue="name">
					<s:param name="label">
						<fmt:message key="wordList.category" />
					</s:param>
					<s:param name="headerKey">
					</s:param>
					<s:param name="headerValue">
						<fmt:message key="wordList.selectCategory" />
					</s:param>
				</s:select>
				<s:radio label="Status" id="learnedStatus" name="learnedStatus"
					list="listLearnedStatus" value="defaultStatusValue" />
			</s:form>
		</div>
		<div id="body-content">
			<s:iterator value="%{listWordCategory}" var="wordCategory"
				status="rowstatus">
				<s:if test="#rowstatus.odd == true">
					<div class="body-left">
						<ul>
							<li><s:property value="#wordCategory.contentResult" /></li>
							<li><s:property value="#wordCategory.contentWord" /></li>
						</ul>
					</div>
				</s:if>
				<s:else>
					<div class="body-right">
						<ul>
							<li><s:property value="#wordCategory.contentResult" /></li>
							<li><s:property value="#wordCategory.contentWord" /></li>
						</ul>
					</div>
				</s:else>
			</s:iterator>
		</div>
	</div>
</div>