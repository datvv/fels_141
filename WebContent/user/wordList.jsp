<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en" />
<fmt:setBundle basename="msg" var="lang" />
<div>
	<div id="wrapper" style="padding-top: 50px">
		<div id="top" align="center">
			<s:form action="#" method="">
				<s:select name="selectedCategory" list="listCategory" listKey="name"
					listValue="name">
					<s:param name="label">
						<fmt:message key="wordList.category" bundle="${lang}" />
					</s:param>
				</s:select>
				<s:radio name="typeFilter"
					list="#{'learned':'learned','notlearned':'not learned','all':'All'}" />
			</s:form>
			<br />
			<div>
				<s:submit type="button">
					<s:param name="value">
						<fmt:message key="wordList.filter" bundle="${lang}" />
					</s:param>
				</s:submit>
			</div>
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