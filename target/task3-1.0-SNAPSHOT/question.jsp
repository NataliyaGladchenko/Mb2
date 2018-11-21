<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 20.11.2018
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<div>
    <table>
        <tr>
            <c:forEach var="question" items="${questionsList}">
            <td><c:out value="${question.questionId}"/></td>
            <td><c:out value="${question.question}"/></td>
        </tr>
        </c:forEach>
    </table>
</div>
<div>
    <form name="return" action="addquestion" method='get'>
        <input type='submit' value='Create question'/>
    </form>
</div>
<div>
    <form name="return" action="question" method="post">
        Number of question: <input type="number" name="question_id">
        <input type="submit" value="delete">
    </form>
</div>
<div>
    <form name="return" action="index" method='get'>
        <input type='submit' value='Return to index'/>
    </form>
</div>
</body>
</html>
