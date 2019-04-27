<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr align="center">
        <td>电影名称</td>
        <td>上映时间 </td>
        <td>简介</td>
        <td>图片保存地址</td>
    </tr>
    <s:iterator  value="StudentList"  var="ux">
        <tr>
            <td><s:property value="#ux.getMoviename()"/></td>
            <td><s:property value="#ux.getShowtime()"/></td>
            <td><s:property value="#ux.getShortinfo()"/></td>
            <td><s:property value="#ux.getPicturepath()"/></td>
        </tr>
    </s:iterator>
</table>
<p>
</body>
</html>
