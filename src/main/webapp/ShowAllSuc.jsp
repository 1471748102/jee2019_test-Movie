<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2019/4/27
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>suc</title>
</head>
<body>
<table border="1">
    <tr align="center">
        <td>电影名称</td>
        <td>上映时间 </td>
        <td>简介</td>
        <td colspan ="1">操作</td>
    </tr>
    <s:iterator  value="StudentList"  var="ux">
        <tr>
            <td><s:property value="#ux.getMoviename()"/></td>
            <td><s:property value="#ux.getShowtime()"/></td>
            <td><s:property value="#ux.getShortinfo()"/></td>

            <td>
                <a href="select.action?moviename=<s:property value="#ux.getMoviename()"/>">查看详细信息</a>
            </td>

        </tr>
    </s:iterator>
</table>
<p>
    <a href="AddMovie.jsp"/>添加新电影信息</a><br>
</body>
</html>
