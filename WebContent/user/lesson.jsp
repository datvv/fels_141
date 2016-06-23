<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="leftLesson">
	<div>
		<s:label name="category.name" />
		<s:label>
			<s:param name="value">
				${currentWord}/${maxWords}
			</s:param>
		</s:label>
	</div>
	<br /> <br />
	<div class="center" id="feedback">
		<s:label name="word.content" />
	</div>
</div>
<div class="rightLesson">
	<div class="center" id="feedback">
		<s:form id="radioBtnForm">
			<s:hidden name="userAnswerContent" id="answerId" />
			<s:iterator value="answerList">
				<s:radio list="#{id:content}" name="answerContent" theme="simple" />
				<br />
			</s:iterator>
		</s:form>
	</div>
</div>