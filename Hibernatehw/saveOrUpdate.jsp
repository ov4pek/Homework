<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit contact</title>
</head>
<body>
<h2>New/Edit contact</h2>
<form:form action="/saveOrUpdateContact" method="post" modelAttribute="contactsEntity">
    <table>
        <tr>
            <form:hidden path="id"/>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><form:input path="phone"/></td>
        </tr>
    </table>
    <input type="submit" value="Save">
</form:form>
</body>
</html>