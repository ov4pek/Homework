<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<h2>Contacts</h2>
<a href="/newContact">New contact</a>
<br/><br/>
<table border="1">
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Phone</th>
    <th>Action</th>
    <c:forEach items="${contactList}" var="contact">
        <tr>
            <td><input type="hidden" name="name" value="${contact.name}">${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.address}</td>
            <td>${contact.phone}</td>
            <td>
                <a href="/editContact/${contact.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/deleteContact/${contact.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>