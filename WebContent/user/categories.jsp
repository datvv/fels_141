<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="wrapperCat">
	<s:iterator value="%{listLessonCategory}" var="lessonCategory"
		status="rowNumber">
		<s:if test="#rowNumber.odd == true">
			<div class="content">
				<div class="content-left">
					<div class="content-left-head">
						<b><s:property value="#lessonCategory.category" /></b>
						<fmt:message key="categories.countlearned" />
						<s:property value="#lessonCategory.learnedCount" />
						/
						<s:property value="#lessonCategory.learnedTotal" />
						<br />
					</div>
					<div class="content-left-text">
						<p>
							<s:property value="#lessonCategory.content" />
						</p>
					</div>
					<div class="content-left-bottom">
						<s:form action="solveProblem" method="GET">
							<button type="submit" class="btn">
								&nbsp;
								<fmt:message key="start" />
								&nbsp;
							</button>
						</s:form>
					</div>
				</div>
				<div class="content-right">
					<div class="content-right-content">
						<!--img src="#" -->
					</div>
				</div>
			</div>
		</s:if>
		<s:else>
			<div class="content">
				<div class="content-left">
					<!-- left -->
					<div class="content-right-content">
						<!-- src image -->
					</div>
				</div>

				<div class="content-right">
					<!-- right -->
					<div class="content-left-head">
						<b><s:property value="#lessonCategory.category" /></b>
						<fmt:message key="categories.countlearned" />
						<s:property value="#lessonCategory.learnedCount" />
						/
						<s:property value="#lessonCategory.learnedTotal" />
						<br />
					</div>
					<div class="content-left-text">
						<p>
							<s:property value="#lessonCategory.content" />
						</p>
					</div>
					<div class="content-left-bottom">
						<s:form action="solveProblem" method="GET">
							<button type="button" class="btn">
								&nbsp;
								<fmt:message key="start" />
								&nbsp;
							</button>
						</s:form>
					</div>
				</div>
			</div>
		</s:else>
	</s:iterator>
</div>
