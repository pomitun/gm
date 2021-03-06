<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-content">
    <div data-bind="foreach: orderProductList">
        Category:<select data-bind="options:categories, optionsText : 'name',optionsValue:'id', value:selectedCategory, optionsCaption:'Select...'"></select>
        Product:<select data-bind="options:selectedProducts, optionsText : 'name', value:selectedProduct, optionsCaption:'Select...'"></select>
        Size:<select data-bind="options:selectedSizes, optionsText : 'name', value:selectedSize, optionsCaption:'Select...'"></select>

        Quantity:<input data-bind="value: quantity" style="width:50px;"/>
        <b>Price:<label data-bind="text: price"></label></b>
        <a href="#" data-bind="click: $root.removeOrderProduct">remove</a>
        <br/>
    </div>
    <button data-bind="click: addOrderProduct, enable: orderProductList().length<3">add</button>
    <br>
    <h3>Total surcharge: $<span data-bind="text: totalSurcharge()"></span></h3>
    <br>
    Master:<select data-bind="options:masters, optionsText : 'name',optionsValue:'id', value:selectedMaster, optionsCaption:'Select...'"></select>
    <input type="button" data-bind="click: sendOrder" value="Submit"/>
    <br>

    Customer: <br>
    Name:<input required="true" data-bind="value: customer.firstName"/> <br>
    Surname:<input data-bind="value: customer.lastName"/> <br>
    Phone:<input data-bind="value: customer.phone"/> <br>
    Address:<input data-bind="value: customer.address"/> <br>
</div>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script>
    var contextPath = "${contextPath}";
</script>

<script src="${contextPath}/lib/jquery-2.1.3.min.js"></script>
<script src="${contextPath}/lib/knockout-3.3.0.js"></script>
<script src="${contextPath}/js/add-order.js"></script>