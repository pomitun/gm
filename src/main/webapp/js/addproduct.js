/**
 * Created by Mary on 23.02.2015.
 */
$(document).ready(function () {
    ////$(".product-color").eq(0).data("id", "");
    ////$(".product-size").eq(0).data("id", "");
    //var product;
    //
    //$('#product-param').submit(function (event) {
    //    event.preventDefault();
    //    alert("submit");
    //    var sizes = [];
    //    for (var i = 0; i < $(".product-size").length; i++) {
    //        if ($(".product-size").eq(i).val() != '') {
    //            sizes[i] = {
    //                id: $(".product-size").eq(i).data("id"),
    //                size: $(".product-size").eq(i).val()
    //            };
    //        }
    //        //  console.log(sizes);
    //    }
    //    // console.log(sizes);
    //
    //    var colors = [];
    //    for (var i = 0; i < $(".product-color").length; i++) {
    //        if ($(".product-color").eq(i).val() != '') {
    //            colors[i] = {
    //                id: $(".product-color").eq(i).data("id"),
    //                color: $(".product-color").eq(i).val(),
    //                image: $(".product-img").eq(i).val()
    //            };
    //        }
    //    }
    //
    //    product = {
    //        productSizes: sizes,
    //        productColors: colors,
    //        name: $("#product-name").val(),
    //        category: {id: $("#product-category").val()},
    //        availability: $("#product-availability").val(),
    //        knitTechnology: $("#product-knit-technology").val()
    //
    //    };
    //    $.ajax({
    //        type: "POST",
    //        url: "http://localhost:8080/product/save.action",
    //        data: JSON.stringify(product),
    //        contentType: "application/json; charset=utf-8",
    //        dataType: "json",
    //        success: function (data) {
    //            alert(data);
    //            console.log(data);
    //        }
    //    });
    //    alert("");
    //    return false;
    //});
    //
    //
    //$('#clickMe').click(function (event) {
    //    alert("click");
    //    console.log(click);
    //});


    function getAllCategories() {
        var categories = [];
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/getAllCategories.action",
            dataType: "json",
            success: function (data) {
                //console.log("categories");
                //console.log(data);
                for(var i=0; i<data.length; i++)
                    categories[i] = {id:data[i].id, name:data[i].name};

            },
            async:false
        });
        return categories;
    }


    function getAllColors(){
        var colors = [];
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/getAllColors.action",
            dataType: "json",
            success: function (data) {
               // console.log("colors");
               // console.log(data);
                for(var i=0; i<data.length; i++)
                    colors[i] = {id:data[i].id, name:data[i].name};
            },
            async:false
        });
        return colors;
    }

    function getAllSizes(){
        var sizes = [];
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/product/getAllSizes.action",
            dataType: "json",
            success: function (data) {
               // console.log("sizes");
                //console.log(data);
                for(var i=0; i<data.length; i++)
                    sizes[i] = {id:data[i].id, name:data[i].name};
            },
            async:false
        });
        return sizes;
    }


    var colorModel = function (id, image, color) {
        var self = this;

        self.id = ko.observable(id);
        self.color = getAllColors();
        self.image = ko.observable(image);
        self.selectedColor = ko.observable(color);
    };

    var sizeModel = function (id, size) {
        var self = this;
        self.id = ko.observable(id);
        self.size = getAllSizes();
        self.selectedSize = ko.observable(size);
    };

    //var productColorModel = function (id, image, colorID) {
    //    var self = this;
    //    self.id = id;
    //    self.image = image;
    //    self.color = {id:colorID};
    //};
    //
    //var productSizeModel = function (id, sizeID) {
    //    var self = this;
    //    self.id = id;
    //    self.size =  {id:sizeID};
    //};

    var productViewModel = function() {
        var self = this;
        self.colors = ko.observableArray();
        self.sizes = ko.observableArray();
        self.name = ko.observable();
        self.availability = ko.observableArray([{val:true}, {val:false}]);
        self.knitTechnology = ko.observable();
        self.categories = getAllCategories();

        self.selectedAvailability = ko.observable();
        self.selectedCategory = ko.observable();
        self.result = ko.observable();

        self.addColor = function(id, image, color) {
            self.colors.push(new colorModel(id, image, color));
        };
        self.removeColor = function(color) { self.colors.remove(color) };


        self.addSize = function(id, size) {
            self.sizes.push(new sizeModel(id, size));
        };
        self.removeSize = function(size) { self.colors.remove(size) };


        self.colors.push(new colorModel());
        self.sizes.push(new sizeModel());

        self.productSizes = ko.observableArray();
        self.productColors = ko.observableArray();

        self.sendMe = function(){

            for(var i=0; i<self.sizes().length; i++){
                if(self.sizes()[i].selectedSize()!=null)
                    self.productSizes.push({size:{id:self.sizes()[i].selectedSize()}}
                    );
            }

            for(var i=0; i<self.colors().length; i++){
                if(self.colors()[i].selectedColor()!=null)
                    self.productColors.push({color:{id: self.colors()[i].selectedColor()}}
                    );
            }

            var product = {
                //id:self.id(),
                name:self.name(),
                productSizes:  self.productSizes(),
                productColors: self.productColors(),
                category: {id:self.selectedCategory()} ,
                availability: self.selectedAvailability(),
                knitTechnology: self.knitTechnology()
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/product/save.action",
                data: JSON.stringify(product),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    alert("saved successfully");
                    console.log(data);
                    //self.result(JSON.stringify(data));

                }
            });
        }
    };

    ko.applyBindings(new productViewModel());

});


