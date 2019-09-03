<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/8/26
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/jquery.ui.widget.js"></script>
    <script src="js/jquery.iframe-transport.js"></script>
    <script src="js/jquery.fileupload.js"></script>
    <script>
        $(function () {
            $("#img").change(function (e) {
                var img = e.target.files[0];
                // 判断是否图片
                if (!img) {
                    return;
                }
            })
        });

    </script>
</head>
<body>
<form id="myForm" method="post" action="/uploadPic"></form>
name:<input type="text" form="myForm" name="name"><br>
pass:<input type="text" form="myForm" name="pass"><br>
<input type="hidden" form="myForm" value=""><br>
<input type="file" form="myForm" value="" id="img">
<input type="submit" form="myForm">
</body>
</html>
