<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<s:form action="importCSV" method="post" enctype="multipart/form-data">
	<s:file name="fileName" label="Import DB" />
	<s:submit />
</s:form>