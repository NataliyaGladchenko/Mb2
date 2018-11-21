<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 20.11.2018
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tr>
            <c:forEach var="users" items="${users}">
            <td><c:out value="${users.userName}"/></td>
        </tr>
        <tr>
            <c:forEach var="answers" items="${users.answersList}">
            <td>Question number</td>
            <td><c:out value="${answers.questionId}"/></td>
            <td>:</td>
            <td><c:out value="${answers.answer}"/></td>
        </tr>
        </c:forEach>
        </c:forEach>
    </table>
</div>
<div>
    <form name="return" action="adduser" method='get'>
        <input type='submit' value='Create user'/>
    </form>
</div>

<div>
    <form name="return" action="question" method='get'>
        <input type='submit' value='questionsList'/>
    </form>

</div>
<div>
    <%--<form name="return" method="post" action="addanswer">--%>
        <%--<input type="submit" value="answer the question"/>--%>
    <%--</form>--%>
</div>
</body>
</html>
