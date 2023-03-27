<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 3/22/2023
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.5/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="flex flex-col items-center justify-center h-screen" data-theme="corporate">
<% if (request.getAttribute("message") != null) {%>
<div class="bg-blue-100 border-t border-b border-blue-500 text-blue-700 px-4 py-3 w-[400px]" role="alert">
    <p class="font-bold">Informational message</p>
    <p class="text-sm">
        <%= request.getAttribute("message") %>
    </p>
    <% } %>
</div>
<h3>Add Student</h3>
<form action="add-student" method="post" class="flex flex-col w-[400px] space-y-2">
    <input type="text" name="firstname" placeholder="your first name" class="input input-bordered"/>
    <input type="text" name="lastname" placeholder="your last name" class="input input-bordered"/>
    <button type="submit" class="btn btn-primary text-primary">Submit</button>
</form>
</body>
</html>
