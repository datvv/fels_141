<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<fmt:setBundle basename="msg"/>
<fmt:setLocale value="en"/>
<div class="leftHome">
	<img src="${user.avatar}"/><br>
	<s:label name="user.username" id="actTitle"></s:label><br>
	<fmt:message key="msg.following"/>: ${fn:length(user.followingList)}
		<fmt:message key="msg.users"/><br>
	<fmt:message key="msg.learned"/>: ${fn:length(user.wordLearnedList)}
		<fmt:message key="msg.words"/><br>
</div>
<div class="rightHome">
	<div>
		<div> 
			<div class="ui-button ui-widget">
			<s:form>
				<s:submit type="button" action="goToWordList" >
					<s:param name="value">
						<fmt:message key="msg.words.button.submit"/>
					</s:param>
				</s:submit>
			</s:form>
			</div>
			<div class="ui-button ui-widget">
			<s:form>				
				<s:submit type="button" action="goToCategories">
					<s:param name="value">
						<fmt:message key="msg.lesson.button.submit"/>
					</s:param>
				</s:submit>
			</s:form>
			</div>
		</div>
	</div>
	<div id="actTitle">
		<fmt:message key="msg.activities"/>
	</div>
	<hr>
	<div>
		<c:forEach items="${user.activityList}" var="oneActivity">
			<img src="${user.avatar}"/>
			<td>${user.username}:</td>
			<td>${oneActivity.actionType}</td><br/>
		</c:forEach>
		<c:forEach items="${user.followingList}" var="oneUser">
			<c:forEach items="${oneUser.activityList}" var="oneActivity">
				<img src="${oneUser.avatar}"/>
				<td>${oneUser.username}:</td>
				<td>${oneActivity.actionType}</td><br/>
			</c:forEach>	
		</c:forEach>
	</div>
</div>