<%--
  Created by IntelliJ IDEA.
  User: zhouzhaoyu
  Date: 17/10/17
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="Dog" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h1>hello,${ sessionScope.testjsp.name }</h1>
<h1><jsp:useBean id="testjsp" class="Dog" scope="session">
    <jsp:getProperty name="testjsp" property="name"></jsp:getProperty>
</jsp:useBean>
</h1>
</body>
</html>
