<%--
  Created by IntelliJ IDEA.
  User: zhouzhaoyu
  Date: 17/10/19
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
</head>
<body>
<form action="${pageContext.request.contentType}/RegisterCheck">
<table>
    <tr>
        <td>用户名<input type="text" name="username"></td>
    </tr>
    <tr>
        <td>密码<input type="password" name="password" ></td>
    </tr>
    <tr>
        <td>确认密码<input type="password" name="rppassword"></td>
    </tr>
    <tr>
        <td>邮箱<input type="text" name="email" ></td>
    </tr>
    <tr>
        <td>生日<input type="text" name="birthday"></td>
    </tr>
    <tr>
        <td><input type="reset" value="reset"><input type="submit" value="submit"></td>
    </tr>
</table></form>
</body>
</html>
