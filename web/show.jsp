<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>show</title>
</head>
<body>
    <table>
        <tr>
            <th>uid</th>
            <th>uname</th>
            <th>password</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.uid}</td>
                <td>${user.uname}</td>
                <td>${user.password}</td>
                <td><a href="/delete.do?uid=${user.uid}">删除</a></td>
                <td><a href="/toUpdate.do?uid=${user.uid}&uname=${user.uname}&password=${user.password}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/toAdd.do">增加</a><font color="red">${insertMsg}${deleteMsg}</font>
</body>
</html>
