<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 3/1/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.4/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="alert alert-success shadow-lg">
    <div>
        <svg xmlns="http://www.w3.org/2000/svg" class="stroke-current flex-shrink-0 h-6 w-6" fill="none"
             viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
        </svg>
        <span>
            ${projectTitle} has been assigned to ${developerId} with task id ${taskId}
        </span>
    </div>
</div>
</body>
</html>
