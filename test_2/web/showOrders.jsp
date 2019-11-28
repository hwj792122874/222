<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>订单信息</h1>
    <table>
        <tr>
            <td><h3>订单编号</h3></td>
            <td><h3>订单总价</h3></td>
            <td><h3>送货地址</h3></td>
            <td><h3>收货人姓名</h3></td>
            <td><h3>收货人电话</h3></td>
            <td><h3>订单状态</h3></td>
            <td><h3>下单时间</h3></td>
            <td><h3>订单所属用户</h3></td>
        </tr>
        <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.money}</td>
            <td>${order.receiverAddress}</td>
            <td>${order.receiverName}</td>
            <td>${order.receiverPhone}</td>
            <td>${order.paystate}</td>
            <td>${order.ordertime}</td>
            <td>${order.user.id}</td>

        </tr>
        </c:forEach>
    </table>
<a href="${pageContext.request.contextPath}/admin/orders/list.jsp">查询及删除订单</a>

</body>
</html>
