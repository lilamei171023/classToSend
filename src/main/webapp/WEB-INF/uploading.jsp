<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/8/3
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<form action="/uploadDatas" method="POST" enctype="multipart/form-data">
    选择文件：<input type="file" name="file"/>
    班级：<input type="text"  name="classroomId">
    属性：<input type="text" name="datasGenre">
    <input type="submit" value="提交"/>

</form>
<form action="/uploadHomework" method="POST" enctype="multipart/form-data">
    选择文件：<input type="file" name="file"/>
    班级：<input type="text"  name="classroomId">
    <input type="submit" value="提交"/>

</form>
<form action="/deleteDatas" method="post">
    文件名：<input type="text"  name="datasName">
    属性：<input type="text"  name="datasGenre">
    班级：<input type="text"  name="classroomId">
    <input type="submit" value="老师删除">
</form>
<form action="/deleteHomework" method="post">
    文件名：<input type="text"  name="homeworkName">
    <input type="submit" value="学生删除">
</form>
<form action="/uploadGrade" method="post">
    文件名：<input type="text"  name="homeworkName">
    成绩：<input type="text"  name="homeworkGrade">
    <input type="submit" value="确定">
</form>

</body>
</html>

