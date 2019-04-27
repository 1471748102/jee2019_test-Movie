<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="movie" method="post">
    <s:textfield name="uk.moviename" label="电影名称"/>
    <s:textfield name="uk.showtime" label="上映时间"/>
    <s:textfield name="uk.shortinfo" label="简介"/>
    <s:textfield name="uk.picturepath" label="上传图片"/>
    <s:submit/>
</s:form>
</body>
</html>
