package com.rusamaha.gm;

import com.rusamaha.gm.model.Order;
import com.rusamaha.gm.services.CategoryService;
import com.rusamaha.gm.services.OrderTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rusamaha on 22/12/15.
 */

@Controller
public class OrderController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderTotalService orderTotalService;

    @RequestMapping("/addOrder.htm")
    public ModelAndView addOrderPage() {
        ModelAndView model = new ModelAndView("order");
        model.addObject("categories", categoryService.getAllCategories());

        return model;
    }

    @RequestMapping("/allOrders.htm")
    public ModelAndView getAllOrders() {
        ModelAndView model = new ModelAndView("orders");
        System.out.print("tt" + orderTotalService.getAllOrders());
        model.addObject("orders", orderTotalService.getAllOrders());
        return model;
    }

    @RequestMapping("/addOrder.action")
    @ResponseBody String addOrderAction(@RequestBody Order order) {
        System.out.println(order.getTotalCost());

        return "success";
    }

}
