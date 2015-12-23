$(document).ready(function () {

    function getAllCategories() {
        var categories = [];
        $.ajax({
            type: "GET",
            url: contextPath + "/product/getAllCategories.action",
            dataType: "json",
            success: function (data) {
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
            url: contextPath + "/product/getAllProducts.action",
            dataType: "json",
            success: function (data) {
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
        self.id = id;
        self.firstName = firstName;
        self.lastName = lastName;
        self.name = firstName + " " + lastName;
    };

    var customerModel= function (id, firstName, lastName, phone, addres) {
        var self = this;
        self.id = id;
        self.firstName =  ko.observable(firstName);
        self.lastName = ko.observable(lastName);
        self.phone = ko.observable(phone);
        self.address = ko.observable(addres);
    };

    var OrderProductModel =  function() {
        var self = this;
        self.categories = ko.observableArray(getAllCategories());
        self.products = ko.observableArray(getAllProducts() );

        self.selectedCategory = ko.observable();
        self.selectedProduct = ko.observable();
        self.selectedSize = ko.observable();

        self.quantity = ko.observable(1);

        self.price = ko.computed(function () {
            if (self.selectedSize() && self.selectedSize().price().price) {
                console.log(self.selectedSize().price().price, self.quantity());
                return self.selectedSize().price().price * self.quantity();
            }
            else
                return 0
        }, self);

        self.selectedProducts = ko.dependentObservable(function () {
            var catiId = self.selectedCategory();

            return ko.utils.arrayFilter(self.products(), function (item) {
                return item.category().id == catiId;
            });

        }, self);

        self.selectedSizes = ko.dependentObservable(function () {
            if(self.selectedProduct()){
                return self.selectedProduct().productSizes();
            }
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

        self.masters = ko.observableArray([new master(1, "Valentina", "Ivanova"),
            new master(2, "Kate", "Smith")]);

        self.selectedMaster = ko.observable();

        self.customer = new customerModel();

        self.addOrderProduct();


        self.sendOrder = function () {
            var orderProducts = ko.utils.arrayMap(self.orderProductList(), function(item) {
                return {
                    productSize: {id: item.selectedSize().id()},
                    quantity: item.quantity()
                };
            });

            var order = {
                orderProducts: orderProducts,
                totalCost: self.totalSurcharge(),
                master:{id:self.selectedMaster()}
                //,
                //customer:self.customer
            };
            console.log(ko.toJSON(order));

            $.ajax({
                type: "POST",
                url: contextPath + "/addOrder.action",
                data: ko.toJSON(order),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data){
                    console.log(data);
                   alert(data);
                },
                async:false
            });
        }
    };

    ko.applyBindings(new OrderViewModel());

});