<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 20.11.2018
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add question</title>
</head>
<body>
<div>

    <form action="addquestion" method="post">
        Question: <input type="text" name="question"/><br/>
        <input type="submit" value="Add Question"/>
    </form>
    <form name="return" action="index" method='get'>
        <input type='submit' value='Return'/>
    </form>
    <form name="return" action="question" method='get'>
        <input type='submit' value='Return to questionList'/>
    </form>
</div>
</body>
</html>
