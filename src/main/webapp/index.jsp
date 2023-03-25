<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.4/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center justify-center h-screen" data-theme="corporate">
<form action="get-weather-servlet" method="post" class="flex flex-col w-[400px] space-y-2">
    <input type="text" name="city" placeholder="Enter your city" class="input input-bordered"/>
    <button type="submit" class="btn btn-primary text-primary">Search</button>
</form>
</body>
</html>