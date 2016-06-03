<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<s:url value="/user/findByUserId"/>1">Show</a>
<a href="<s:url value="/user/findByUsername"/>manh">Find by name</a>

<c:redirect url="/views/login.jsp"></c:redirect>