<%@ page import="com.jetbrains.firstpr.Models.WeatherData" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.4/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center justify-center h-screen" data-theme="corporate">
<%
    WeatherData data = (WeatherData) request.getAttribute("weatherData");
    String city = (String) request.getAttribute("city");
%>
<div class="card w-96 bg-base-100 shadow-xl">
    <figure><img src="/images/stock/photo-1606107557195-0e29a4b5b4aa.jpg" alt="Shoes"/></figure>
    <div class="card-body">
        <h2 class="card-title">
            <%= city %>
            <div class="badge badge-secondary">
                <%= data.getTemp() %> °C
            </div>
        </h2>
        <p>If a dog chews shoes whose shoes does he choose?</p>
        <div class="card-actions justify-end">
            <div class="badge badge-outline">
                <%= data.getHumidity() %> %
            </div>
            <div class="badge badge-outline">
                <%= data.getPressure() %>
            </div>
        </div>
    </div>
</div>
</body>
</html>