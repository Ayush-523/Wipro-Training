<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>

<body>

<h1>Edit User</h1>

<form action="../update" method="post">

    ID:
    <input type="text"
           name="id"
           value="${user.id}"
           readonly>

    <br><br>

    Name:
    <input type="text"
           name="name"
           value="${user.name}">

    <br><br>

    Email:
    <input type="text"
           name="email"
           value="${user.email}">

    <br><br>

    <input type="submit"
           value="Update User">

</form>

</body>
</html>