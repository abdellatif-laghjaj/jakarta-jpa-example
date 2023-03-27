<%@ page import="com.jetbrains.firstpr.Models.Student" %>
<%@ page import="com.jetbrains.firstpr.Connection.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.5/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="flex flex-col items-center justify-center h-screen" data-theme="corporate">
<c:set var="id" value="${param.id}"/>
<c:set var="student" value="${requestScope.student}"/>

<% if (request.getAttribute("message") != null) {%>
<div class="bg-blue-100 border-t border-b border-blue-500 text-blue-700 px-4 py-3 w-[400px]" role="alert">
    <p class="font-bold">Informational message</p>
    <p class="text-sm">
        <%= request.getAttribute("message") %>
    </p>
    <% } %>
</div>
<h3>Add Student #${param.id}</h3>
<form action="${pageContext.request.contextPath}/students/update?id=${param.id}" method="post"
      class="flex flex-col w-[400px] space-y-2">
    <input type="text" name="firstname" placeholder="your first name" class="input input-bordered"
           value="${student.getFirstname()}"/>
    <input type="text" name="lastname" placeholder="your last name" class="input input-bordered"
           value="${student.getLastname()}"/>
    <button type="submit" class="btn btn-primary text-primary">Update</button>
</form>
</body>
</html>