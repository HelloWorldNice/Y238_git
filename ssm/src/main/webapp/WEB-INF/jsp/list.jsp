<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${pageInfo.list}" var="account">
        ${account.id} -- ${account.name}-- ${account.age} <br/>
    </c:forEach>

    <c:if test="${!pageInfo.isFirstPage}">
        <a href="${pageContext.request.contextPath}/queryAllByPage?pageNum=1">首页</a>
    </c:if>

    <c:forEach items="${pageInfo.navigatepageNums}" var="index">
        <c:if test="${index == pageInfo.pageNum}">
            <font color="red">[第${index}页]</font>
        </c:if>
        <c:if test="${index != pageInfo.pageNum}">
            <a href="${pageContext.request.contextPath}/queryAllByPage?pageNum=${index}">[第${index}页]</a>
        </c:if>
    </c:forEach>

    <c:if test="${!pageInfo.isLastPage}">
        <a href="${pageContext.request.contextPath}/queryAllByPage?pageNum=${pageInfo.pages}">尾页</a>
    </c:if>


    总条数： ${pageInfo.total} <br/>
    总页数：${pageInfo.pages} <br/>
    当前是第${pageInfo.pageNum}页 <br/>
    导航页码数：${pageInfo.navigatePages} <br/>
</body>
</html>
