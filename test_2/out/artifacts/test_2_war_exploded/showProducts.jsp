<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>商品信息</h1>
    <table>
        <tr>
            <td><h3>商品名称</h3></td>
            <td><h3>商品价格</h3></td>
            <td><h3>商品分类</h3></td>
            <td><h3>商品数量</h3></td>
            <td><h3>商品描述</h3></td>
        </tr>
        <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td>${product.pnum}</td>
            <td>${product.description}</td>
        </tr>
        </c:forEach>
    </table>
<a href="${pageContext.request.contextPath}/admin/products/add.jsp">添加商品</a>
<a href="${pageContext.request.contextPath}/admin/products/edit.jsp">修改商品</a>
<a href="${pageContext.request.contextPath}/admin/products/list.jsp">查询删除商品</a>
</body>
</html>
