<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mary
  Date: 22.09.2015
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>All Orders:</h3>
<table style="border: solid 1px #cecece; text-align: center">
    <tr>
        <td>Quantity</td>
        <td>Color ID</td>
        <td>Color</td>
        <td><b>Total Coast</b></td>
    </tr>
    <c:forEach items="${orders}" var="order">
        <c:forEach items="${order.orderProducts}" var="orderProduct">
            <tr>
                <td>${orderProduct.quantity}</td>
                <td>${orderProduct.productColor.id}</td>
                <td>${orderProduct.productColor.color.name}</td>
                <td>${order.totalCost}</td>
            </tr>
        </c:forEach>
    </c:forEach>
<%--<c:forEach items="${orders}" var="order">--%>
    <%--<div><span>totalCost: </span>${order.totalCost}</div>--%>
    <%--<c:forEach items="${order.orderProducts}" var="orderProduct">--%>
        <%--<div><span>quantity: </span>${orderProduct.quantity}</div>--%>
        <%--<div><span>productColor id: </span>${orderProduct.productColor.id}</div>--%>
        <%--<div><span>productColor: </span>${orderProduct.productColor.color.name}</div>--%>
    <%--</c:forEach>--%>

    <%--&lt;%&ndash;${order.totalCost}&ndash;%&gt;--%>
    <%--&lt;%&ndash;${order.totalCost}&ndash;%&gt;--%>

<%--</c:forEach>--%>
</table>
</body>
</html>
