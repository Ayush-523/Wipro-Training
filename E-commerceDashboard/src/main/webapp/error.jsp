<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <div class="alert alert-danger">
        <%= request.getAttribute("errorMessage") %>
    </div>

    <a href="login.jsp" class="btn btn-secondary">Back to Login</a>

</body>
</html>