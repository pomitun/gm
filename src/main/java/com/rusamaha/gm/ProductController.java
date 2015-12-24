package com.rusamaha.gm;


import com.rusamaha.gm.model.*;
import com.rusamaha.gm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
* Created by Mary on 23.02.2015.
*/
@Controller
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productService;

    @Autowired
    ColorService colorService;

    @Autowired
    ProductColorService productColorService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ProductSizeService productSizeService;

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/save.action")
    public  @ResponseBody
    ProductBase saveProduct( @RequestBody ProductBase product) {
        System.out.println("id:" + product.getId()+
                " name" + product.getName()+
                " availability" + product.getAvailability()+
                " knitTechnology"+ product.getKnitTechnology()+
        " category"+product.getCategory()+
        " productSizes.id"+product.getProductSizes());

        return productService.saveOrUpdate(product);
    }

    @RequestMapping("/getAllColors.action")
    public  @ResponseBody
    Iterable<Color> getAllColors() {
        return colorService.getAllColors();
    }

    @RequestMapping("/getAllProductColors.action")
    public  @ResponseBody
    Iterable<ProductColor> getAllProductColors() {
        return productColorService.getAllProductColors();
    }

    @RequestMapping("/getAllSizes.action")
    public  @ResponseBody
    Iterable<Size> getAllSizes() {
        return sizeService.getAllSizes();
    }

    @RequestMapping("/getAllProductSizes.action")
    public  @ResponseBody
    Iterable<ProductSize> getAllProductSizes() {
        return productSizeService.getAllProductSizes();
    }

    @RequestMapping("getAllCategories")
    public  @ResponseBody
    Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping("getAllProducts")
    public  @ResponseBody
    Iterable<ProductBase> getAllProducts() {
        return productService.getAllProducts();
    }


    @RequestMapping("/findProduct.htm")
    public ModelAndView findProductPage() {
        ModelAndView model = new ModelAndView("find");
        List<String> productsName = new ArrayList<>();
        for(ProductBase productBase : productService.getAllProducts()){
            productsName.add(productBase.getName());
        }
        model.addObject("productsName", productsName);

        return model;
    }

    @RequestMapping(value = "/findProduct.action")
    public  @ResponseBody List<ProductBase> findProduct(@RequestBody String name)  throws IOException {
        return productService.findByName(name);

    }

}
