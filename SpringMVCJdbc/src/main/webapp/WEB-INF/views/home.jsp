<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<body>

<h1>User Management System</h1>

<a href="register">Add User</a>

<br><br>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Actions</th>
</tr>

<c:forEach items="${users}" var="u">

<tr>

    <td>${u.id}</td>
    <td>${u.name}</td>
    <td>${u.email}</td>

    <td>

        <a href="edit/${u.id}">
            Edit
        </a>

        |

        <a href="delete/${u.id}"
           onclick="return confirm('Delete User?')">

            Delete

        </a>

    </td>

</tr>

</c:forEach>

</table>

</body>
</html>