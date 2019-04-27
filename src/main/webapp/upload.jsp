<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form name="upload" action="upload" method="post" enctype="multipart/form-data">
    <s:file name="upload" label="选择要上传的文件"/>
    <s:submit/>
</s:form>
</body>
</html>
