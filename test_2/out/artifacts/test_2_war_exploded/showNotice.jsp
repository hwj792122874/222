<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>公告信息</h1>
    <table>
        <tr>
            <td><h3>公告编号</h3></td>
            <td><h3>公告标题</h3></td>
            <td><h3>公告内容</h3></td>
            <td><h3>时间</h3></td>
        </tr>
        <c:forEach items="${notices}" var="notice">
        <tr>
            <td>${notice.n_id}</td>
            <td>${notice.title}</td>
            <td>${notice.details}</td>
            <td>${notice.n_time}</td>
        </tr>
        </c:forEach>
    </table>
<a href="${pageContext.request.contextPath}/admin/notices/add.jsp">添加公告</a>
<a href="${pageContext.request.contextPath}/admin/notices/edit.jsp">修改公告</a>
<a href="${pageContext.request.contextPath}/admin/notices/list.jsp">删除公告</a>
</body>
</html>
