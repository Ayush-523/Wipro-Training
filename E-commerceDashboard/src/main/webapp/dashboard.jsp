<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <h2>Welcome to QuickCart Dashboard</h2>

    <div class="alert alert-success">
        <%= request.getParameter("msg") %>
    </div>

    <h4 class="mt-4">Products</h4>

    <ul class="list-group w-50">
        <%
            List<String> products = (List<String>) request.getAttribute("products");
            for(String p : products){
        %>
            <li class="list-group-item"><%= p %></li>
        <%
            }
        %>
    </ul>

</body>
</html>