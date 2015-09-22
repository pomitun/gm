<div class="page-content">
    <form class="product-param" id="product-param">
        <input type="hidden" class="product-id"/>

        Name
        <input id="product-name" class="product-name" data-bind="value: name"/>
        <br>
        Category
        <select data-bind="options: categories, optionsText: 'name', optionsValue: 'id',
                      value: selectedCategory, optionsCaption: 'Choose..'">
        </select>
        <%--<select id="product-category" class="product-category">--%>
            <%--<c:forEach var="category" items="${categories}">--%>
                <%--<option value='${category.id}'>${category.name}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
        <br>

        Availability
        <select data-bind="options: availability, optionsText: 'val', optionsValue: 'val',
                      value: selectedAvailability, optionsCaption: 'Choose..'">
        </select>
        <%--<select id="product-availability" class="product-availability">--%>
            <%--<option value="true">true</option>--%>
            <%--<option value="false">false</option>--%>
        <%--</select>--%>
        <br>

        Knit technology
        <textarea id="product-knit-technology" data-bind="value: knitTechnology"></textarea>

        <div class="container" data-bind="foreach: sizes">
        Size
        <select data-bind="options: size, optionsText: 'name', optionsValue: 'id',
                      value: selectedSize, optionsCaption: 'Choose..'">
        </select>
            <%--<select id="product-size_0" class="product-size">--%>
                <%--<c:forEach var="size" items="${sizes}">--%>
                    <%--<option value='${size}'>${size}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        </div>

        <div class="container" data-bind="foreach: colors">
            Color
            <select data-bind="options: color, optionsText: 'name', optionsValue: 'id',
                      value: selectedColor, optionsCaption: 'Choose..'">
            </select>

            <%--<select id="product-color_0" class="product-color">--%>
                <%--<c:forEach var="color" items="${colors}">--%>
                    <%--<option value='${color}'>${color}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
            Image
            <input id="product-img" class="product-img" data-bind="value:image"/>
            <%--<input  type="file" name="file" id="product-img" class="product-img"/>--%>
        </div>

        <input type="button" data-bind="click: sendMe" value="Save"/>
    </form>

    <span data-bind="text:result"></span>

</div>



