$(document).ready(function () {

    function getAllCategories() {
        var categories = [];
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/getAllCategories.action",
            dataType: "json",
            success: function (data) {
                console.log("categories");
                console.log(data);
                for(var i=0; i<data.length; i++)
                    categories[i] = new category(data[i].id, data[i].name);

            },
            async:false
        });
        return categories;
    }

    function getAllProducts() {
        var products = [];
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/getAllProducts.action",
            dataType: "json",
            success: function (data) {
                console.log("products");
                console.log(data);

                $.each(data, function(index, item) {
                    var sizes = [];
                    $.each(item.productSizes, function( i, iSize ) {
                        sizes.push(new size(iSize));
                    });

                    var colors = [];
                    $.each(item.productColors, function( i, iColor ) {
                        colors.push(new color(iColor));
                    });

                    products[index] = new product(item.id, item.category.id, item.name, sizes, colors);
                });
            },
            async:false
        });
        return products;
    }

    //function getAllColors(){
    //    var colors = [];
    //    $.ajax({
    //        type: "GET",
    //        url: "http://localhost:8080/product/getAllProductColors.action",
    //        dataType: "json",
    //        success: function (data) {
    //            console.log("colors");
    //            console.log(data);
    //            for(var i=0; i<data.length; i++)
    //                colors[i] = new color(data[i].id, data[i].product.id, data[i].color);
    //        },
    //        async:false
    //    });
    //    return colors;
    //}
    //
    //function getAllSizes(){
    //    var sizes = [];
    //    $.ajax({
    //        type: "GET",
    //        url: "http://localhost:8080/product/getAllProductSizes.action",
    //        dataType: "json",
    //        success: function (data) {
    //            console.log("sizes");
    //            console.log(data);
    //            for(var i=0; i<data.length; i++)
    //                sizes[i] = new size(data[i].id, data[i].product.id, data[i].customSize, data[i].price);
    //
    //
    //        },
    //        async:false
    //    });
    //    return sizes;
    //}

    var category = function (id, name) {
        var self = this;
        self.id = ko.observable(id);
        self.name = ko.observable(name);
    };

    var product = function (id, cid, name, sizes, colors) {
        var self = this;
        self.id = ko.observable(id);
        self.category = ko.observable({id:cid});
        self.name = ko.observable(name);
        self.productSizes = ko.observableArray(sizes);
        self.productColors = ko.observableArray(colors);
    };

    var size = function (data) {
        var self = this;
        self.id = ko.observable(data.id);
        self.name = ko.observable(data.size.name);
        self.price = ko.observable(data.price);
    };

    var color = function (data) {
        var self = this;
        self.id = ko.observable(data.id);
        self.color = ko.observable(data.name);
    };

    var master = function (id, firstName, lastName) {
        var self = this;
        self.id = ko.observable(id);
        self.firstName = ko.observable(firstName);
        self.lastName = ko.observable(lastName);
    };

    var OrderProductModel =  function() {
        var self = this;
        self.categories = ko.observableArray(getAllCategories());
        self.products = ko.observableArray(getAllProducts() );
        //self.sizes = ko.observableArray(getAllSizes());
        //self.colors = ko.observableArray(getAllColors());

        // keep track of selected country
        self.selectedCategory = ko.observable();
        self.selectedProduct = ko.observable();
        self.selectedSize = ko.observable();

        self.quantity = ko.observable(1);

        self.price = ko.computed(function () {
            if (self.selectedSize() && self.selectedSize().price)
                return self.selectedSize().price * self.quantity();
            else
                return 0
        }, self);

        // change state selection based on country selection
        self.selectedProducts = ko.dependentObservable(function () {
            var catiId = self.selectedCategory();

            return ko.utils.arrayFilter(self.products(), function (item) {
                return item.category().id == catiId;
            });

        }, self);

        // change state selection based on country selection
        self.selectedSizes = ko.dependentObservable(function () {
            if(self.selectedProduct()){
                console.log(self.selectedProduct());
                console.log(self.selectedProduct().productSizes());
                return self.selectedProduct().productSizes();
            }
            //var prodId = self.selectedProduct();
            //
            //return ko.utils.arrayFilter(self.sizes(), function (item) {
            //    return item.product().id == prodId;
            //});
        }, self);
    };

    var OrderViewModel = function() {
        var self = this;
        self.orderProductList = ko.observableArray();

        self.addOrderProduct = function () {
            self.orderProductList.push(new OrderProductModel());
        };

        self.removeOrderProduct = function (orderProduct) {
            self.orderProductList.remove(orderProduct)
        };

        self.totalSurcharge = ko.computed(function () {
            var total = 0;
            for (var i = 0; i < self.orderProductList().length; i++)
                total += self.orderProductList()[i].price();
            return total;
        });

        self.masters = ko.observableArray([new master(1, "Valentina"),
            new master(2, "Kate")]);
        self.selectedMaster = ko.observable();

        self.addOrderProduct();


        self.sendOrder = function () {

        }
    };

    // Activates knockout.js
    ko.applyBindings(new OrderViewModel());

});