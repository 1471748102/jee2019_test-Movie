<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 7:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="Login" method="post">
    <s:textfield name="username" label="账号"/>
    <s:textfield name="password" label="密码"/>
    <s:submit/>
</s:form>
</body>
</html>
