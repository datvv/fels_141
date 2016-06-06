<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrapper" style="padding-top: 50px">
		<div id="top">
			<p>Category</p>
			<s:form action="filterAction" method="filterWordList">
				<select name="selectCategory">
					<option value="">All</option>
					<s:iterator value="%{listCategory}" var="category">
						<option value='<s:property value="#category.name"/>'
							 ${category.name == selectCategory ? "SELECTED":""  }
							 >
							<s:property value="#category.name" /></option>
					</s:iterator>
				</select>
				<input type="radio" name="learnedStatus" value="learned" ${learnedStatus eq "learned" ? 'checked="checked"' :""  } >learned
				<input type="radio" name="learnedStatus" value="notlearned" ${learnedStatus eq "notlearned" ? 'checked="checked"' :""  } >not
				learned <input type="radio" name="learnedStatus" value="all"  ${learnedStatus eq "all" ? 'checked="checked"' :""  } >All<br />
				<br />
				<div align="center">
					<input type="submit" value="Filter" name="filter">
				</div>
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
</body>
</html>