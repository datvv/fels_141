<%@taglib uri="/struts-tags" prefix="s"%>
<body>
<h1>Sign-up</h1>
<div>
	<s:form action="signUp" method="post" enctype="multipart/form-data">
		<s:textfield name="user.email" label="Email"/>
		<s:textfield name="user.username" label="User Name"/>
		<s:password name="user.password" label="Password"/>
		<s:password name="passwordConfirm" label="Confirm password"/>
		<s:submit value="Sign Up" align="center"/>
	</s:form>
</div>	
</body> 