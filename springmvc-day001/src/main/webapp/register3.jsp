<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        $(function(){
            // 提交表单
            $("#registerBtn").click(function(){
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/userRegister",
                    type: "POST",
                    data: $("#form").serialize(),
                    success: function(respData){
                        console.log(respData);
                        console.log(respData.code);
                        console.log(respData.data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <form id="form">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="text" name="password"><br/>
        年龄：<input type="text" name="age"><br/>
        <input type="button" id="registerBtn" value="注册"/>
    </form>
</body>
</html>
