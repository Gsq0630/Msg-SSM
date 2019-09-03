<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="page" uri="http://page.lanqiao.org/tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    姓名：<input type="text" name="userName">
    密码：<input type="text" name="userPass">
    头像：<input type="file" name="userPic">
    <div></div>
    <page:page pageNo="${pageInfo.pageNum}" totalRecord="${pageInfo.total}" pageSize="${pageInfo.pageSize}" url="/index"/>
    <input type="submit">
</form>


</body>
</html>
