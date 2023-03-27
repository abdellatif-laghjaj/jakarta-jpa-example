<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 3/1/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Home Page</title>
</head>
<body>

<div style="text-align: center">
    <c:if test="${sessionScope.fullname == null}">
        <h1>Hey Guest</h1>
    </c:if>
    <h1>hey ${ sessionScope.fullname }</h1>
    <br><br>
    <a href="/logout">Logout</a>
</div>
</body>
</html>
