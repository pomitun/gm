package com.rusamaha.gm;

import com.rusamaha.gm.model.Color;
import com.rusamaha.gm.model.Size;
import com.rusamaha.gm.services.CategoryService;
import com.rusamaha.gm.services.ProductService;
import com.rusamaha.gm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mary on 19.02.2015.
 */
@Controller
public class WelcomeController {


//    @Autowired
//    UserService userService;
//
//    @RequestMapping("/")
//     public String index(Model model) {
//
//        model.addAttribute("logins", userService.getLogins());
//        model.addAttribute("users", userService.getAllUsers());
//        model.addAttribute("demo", "HELLO DEMO!");
//        return "hello";
//    }

    @Autowired
    CategoryService categoryService;
//

    @Autowired
    ProductService productService;
    @RequestMapping("/hello.htm")
     public ModelAndView tasks() {
        ModelAndView model = new ModelAndView("hello");
        model.addObject("demo", "HELLO DEMO!");
        model.addObject("categories", categoryService.getAllCategories());
//        model.addObject("categories", productService.getAllProducts());

        //model.addObject("sizes", Size.values());
        //model.addObject("colors", Color.values());
        return model;
    }

    @RequestMapping("/order.htm")
    public ModelAndView order() {
        ModelAndView model = new ModelAndView("order");
        model.addObject("demo", "HELLO DEMO!");
        //model.addObject("sizes", Size.values());
        //model.addObject("colors", Color.values());
        return model;
    }


}
