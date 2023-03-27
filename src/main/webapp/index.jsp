<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jetbrains.firstpr.Models.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.51.4/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex flex-col items-center justify-center h-screen" data-theme="corporate">
<% List<Task> tasksList = (List<Task>) request.getAttribute("tasksList"); %>
<form action="create-project-servlet" method="post" class="flex flex-col w-[400px] space-y-2" id="loginForm">
    <input type="text" name="title" placeholder="Project tile..." class="input input-bordered"/>
    <select class="select select-primary w-full" name="developerId">
        <option disabled selected>Select developer</option>
        <option value="1">Developer 1</option>
        <option value="2">Developer 2</option>
        <option value="3">Developer 3</option>
    </select>
    <select class="select select-primary w-full" name="taskId">
        <option disabled selected>Select task</option>
        <option value="1">Task 1</option>
        <option value="2">Task 2</option>
        <option value="3">Task 3</option>
    </select>
    <input type="date" name="startDate" placeholder="12/12/2020" class="input input-bordered"/>
    <input type="number" name="duration" placeholder="Duration..." class="input input-bordered"/>
    <span>
        ${message}
    </span>
    <button type="submit" class="btn btn-primary text-primary">Submit</button>
</form>
</body>
<script type="text/javascript">

    $(document).ready(function () {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>

</html>