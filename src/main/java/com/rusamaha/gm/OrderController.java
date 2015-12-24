package com.rusamaha.gm;

import com.rusamaha.gm.model.Order;
import com.rusamaha.gm.services.CategoryService;
import com.rusamaha.gm.services.OrderTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.io.IOException;

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

    @RequestMapping(value = "/addOrder.action", produces="text/plain")
    public void addOrderAction(@RequestBody Order order, HttpServletResponse response)  throws IOException {
        orderTotalService.saveOrder(order);
        response.getWriter().println("success");
    }

    @RequestMapping(value = "/deleteOrder.action", produces="text/plain")
    public void deleteOrder(@RequestBody Long id, HttpServletResponse response)  throws IOException  {
        orderTotalService.deleteOrderByID(id);
        response.getWriter().println("success");
    }



}
