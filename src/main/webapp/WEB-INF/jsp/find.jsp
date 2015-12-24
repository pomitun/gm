<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="findForm">
    <input id="productName" type="text" required="required"/>
    <input  type="submit" name="find"/>
</form>
<div id="finder"></div>
</body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script src="${contextPath}/lib/jquery-2.1.3.min.js"></script>
<script>
    var products = "${productsName}";
    var contextPath = "${contextPath}";
//    $('#productName').autocomplete({
//        minChars: 2, // Минимальная длина запроса для срабатывания автозаполнения
//        delimiter: /(,|;)\s*/, // Разделитель для нескольких запросов, символ или регулярное выражение
//        maxHeight: 400, // Максимальная высота списка подсказок, в пикселях
//        width: 300, // Ширина списка
//        zIndex: 9999, // z-index списка
//        deferRequestBy: 0, // Задержка запроса (мсек), на случай, если мы не хотим слать миллион запросов, пока пользователь печатает. Я обычно ставлю 300.
//        //params: { country: 'Yes'}, // Дополнительные параметры
//        onSelect: function(data, value){ }, // Callback функция, срабатывающая на выбор одного из предложенных вариантов,
//        source: products// Список вариантов для локального автозаполнения
//    });

    $("#findForm").submit(function(event){
        event.stopPropagation();
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: contextPath + "/product/findProduct.action",
            data: JSON.stringify($("#productName").val()),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data){
                console.log(data);

            },
            async:false
        });
    });

</script>
</html>
