<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>用户注册</h1>
    <form action="${pageContext.request.contextPath}/user/testRequestBody" method="post">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="text" name="password"><br/>
        年龄：<input type="text" name="age"><br/>
        出生日期: <input type="text" name="born"><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
