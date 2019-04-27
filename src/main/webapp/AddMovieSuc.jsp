<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
电影信息插入成功！<br>
电影名称：<s:property value="uk.moviename"/><br>
上映时间：<s:property value="uk.showtime"/><br>
简介：<s:property value="uk.shortinfo"/><br>
图片地址：<s:property value="uk.picturepath"/><br>
<%  response.setHeader("refresh","3;URL=ShowAllMovie.jsp");%>
</body>
</html>
