<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Contacts</title>
</head>
<body>
<h2>Contacts</h2>
<a href="/newContact">New contact</a>
<br/>
<table border="1">
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Phone</th>
    <th>Action</th>
    <c:forEach var="contact" items="${listContact}">
        <tr>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.address}</td>
            <td>${contact.phone}</td>
            <td>
                <a href="/editContact?id=${contact.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/deleteContact?id=${contact.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>