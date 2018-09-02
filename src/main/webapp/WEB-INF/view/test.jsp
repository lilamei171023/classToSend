
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
<form action="/Student/selectByNo/" method="post">
    学工号:<input type="text" name="student_no"/><br/>
    班级id:<input type="text" name="classroom_id"/><br/>
    <input type="submit" value="提交"/>
</form>
-->
<form action="/Student/agreeJoin/" method="post">
    学工号:<input type="text" name="student_number"/><br/>
    班级id:<input type="text" name="invitation_code"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
