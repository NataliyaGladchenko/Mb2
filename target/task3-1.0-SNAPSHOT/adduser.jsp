<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add User Form</title>
</head>
<body>
<br/>
<div>
    <table>
        <tr>
            <c:forEach var="user" items="${users}">
            <td><c:out value="${user.userId}"/></td>
            <td><c:out value="${user.userName}"/></td>
        </tr>
        </c:forEach>
</div>
<div>
    <form action="adduser" method="post">
        User name: <input type="text" name="user_name"/><br/>
        <input type="submit" value="Add User"/>
    </form>
    <form name="return" action="index" method='get'>
        <input type='submit' value='Return'/>
    </form>
</div>
</body>
</html>