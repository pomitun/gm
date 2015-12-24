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

    <c:forEach items="${orders}" var="order">
    <table id="${order.id}" style=" text-align: center; width: 40%; border: solid 1px #cecece; margin: 0 0 20px 0 ">
        <tr>
            <td colspan="4">
                <b style="float: left;">ORDER ID ${order.id}</b>
            </td>
            <td>
                <input type="button" onclick="deleteOrder(${order.id})" value="Delete"/>
            </td>
        </tr>
        <tr style="font: 17px bold Arial">
            <td>Quantity</td>
            <td>Size</td>
            <td>Color ID</td>
            <td>Color</td>
            <td><b>Total Coast</b></td>
        </tr>

        <c:forEach items="${order.orderProducts}" var="orderProduct">
            <tr>
                <td>${orderProduct.quantity}</td>
                <td>${orderProduct.productSize.customSize.name}</td>
                <td>${orderProduct.productColor.id}</td>
                <td>${orderProduct.productColor.color.name}</td>

            </tr>
        </c:forEach>
            <tr style="border: solid 1px #cecece">
                <td colspan="6" style="border-top: solid 1px #cecece">
                    <div style="width:30%; float: right; text-align: center">${order.totalCost}</div>
                </td>
            </tr>
        </table>
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

</body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script>
    var contextPath = "${contextPath}";
</script>
<script src="${contextPath}/lib/jquery-2.1.3.min.js"></script>
<script src="${contextPath}/js/orders.js"></script>
</html>
