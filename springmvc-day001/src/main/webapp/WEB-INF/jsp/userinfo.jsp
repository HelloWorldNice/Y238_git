<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    姓名： ${user.username} <br/>
    年龄： ${user.age} <br/>
    出生日期：
    <fmt:formatDate value="${user.born}" pattern="yyyy-MM-dd HH:mm:ss"/>
    <br/>

    <c:forEach items="${user.addressList}" var="address">
        省份：${address.province}--市：${address.city} <br/>
    </c:forEach>

</body>
</html>
