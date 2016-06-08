<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrapper" style="padding-left: 100px; padding-right: 100px;">

		<s:iterator value="%{listUserCategory}" var="userCategory"
			status="rowNumber">
			<s:if test="#rowNumber.odd == true">
				<div class="content" style="margin-top: 50px">
					<div class="content-left">
						<div class="content-left-head">
							<b><s:property value="#userCategory.category" /> </b> Your've
							learned
							<s:property value="#userCategory.learnedCount" />
							/
							<s:property value="#userCategory.learnedTotal" />
							<br />
						</div>
						<div class="content-left-text">
							<p>
								<s:property value="#userCategory.content" />
							</p>
						</div>
						<div class="content-left-bottom">
							<button type="button" class="btn">&nbsp;Start&nbsp;</button>
						</div>
					</div>
					<div class="content-right">
						<div class="content-right-content">
							<!--<img src="#" class="img-rounded" alt="Cinque Terre" width="300" height="200">-->
						</div>
					</div>
				</div>
			</s:if>
			<!-- 2 -->
			<s:else>
				<div class="content">
					<div class="content-left">
						<!-- left -->

						<div class="content-right-content">
							<!--<img src="#" class="img-rounded" alt="Cinque Terre" width="300" height="200">-->
						</div>
					</div>

					<div class="content-right">
						<!-- right -->
						<div class="content-left-head">
							<b><s:property value="#userCategory.category" /> </b> Your've
							learned
							<s:property value="#userCategory.learnedCount" />
							/
							<s:property value="#userCategory.learnedTotal" />
							<br />
						</div>
						<div class="content-left-text">
							<p>
								<s:property value="#userCategory.content" />
							</p>
						</div>
						<div class="content-left-bottom">
							<button type="button" class="btn">&nbsp;Start&nbsp;</button>
						</div>

					</div>
				</div>
			</s:else>

		</s:iterator>

	</div>
</body>
</html>