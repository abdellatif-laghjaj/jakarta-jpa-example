<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.5/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body data-theme="corporate">
<form action="login" method="post">
    <input type="text" name="email" placeholder="your email...">
    <input type="password" placeholder="your password" name="password">
    <button type="submit">Submit</button>
    <a href="${pageContext.request.contextPath}/students">
        Students
    </a>
</form>
</body>
</html>