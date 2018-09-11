<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/update.do" method="post">
        uid:<input type="text" name="uid" value="${userinfos.uid}" readonly/>
        uname:<input type="text" name="uname" value="${userinfos.uname}"/>
        password:<input type="password" name="password" value="${userinfos.password}"/>
        <input type="submit" value="ok"/>
    </form>
</body>
</html>
