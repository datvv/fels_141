<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:label id="categoryStyle" name="category.name" />
<s:label id="categoryStyle">
	<s:param name="value">
		${numberOfTrueAnswer}/${numberOfQuestion}
	</s:param>
</s:label>
<br />
<div class="centerBlock">
	<c:forEach items="${mapWordAndUserAnswer}" var="entry">
		<div class="inline">
			<c:if test="${entry.value.correct==true}">
				<img src="<c:url value="/icon-result/true.png" />" />
			</c:if>
			<c:if test="${entry.value.correct==false}">
				<img src="<c:url value="/icon-result/false.png" />" />
			</c:if>
		</div>
		<div class="inline" id="wordStyle">${entry.key.content}</div>
		<div class="inline" id="wordAnswerStyle">${entry.value.content}</div>
		<br class="clearBoth">
	</c:forEach>
</div>
