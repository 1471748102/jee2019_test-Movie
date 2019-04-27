<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>注册</title>
</head>
<body>
<s:debug/>
<s:form action="CheckAction" >
    <s:textfield name="username" label="账号"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="reapeat" label="重复密码"/>
    <s:submit/>
</s:form>

</body>
</html>
