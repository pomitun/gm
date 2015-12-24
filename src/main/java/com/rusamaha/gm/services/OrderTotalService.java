package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.OrderTotalDao;
import com.rusamaha.gm.model.Order;
import com.rusamaha.gm.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusamaha on 22/12/15.
 */

@Service
@Transactional
public class OrderTotalService {

    @Autowired
    private OrderTotalDao orderTotal;

    public Iterable<Order> getAllOrders() {
        System.out.print("kkk");
        Iterable<Order> orders = orderTotal.findAll();

//        for (Order order : orders){
//            List<OrderProduct> orderProducts = order.getOrderProducts();
//            for(OrderProduct orderProduct : orderProducts) {
//                orderProduct.getProductColor().getColor();
//                System.out.println(orderProduct.getProductColor().getColor().getName());
//
////                System.out.println(orderProduct.getId());
//            }
//        }
//        System.out.print(orders);
        return orders;
    }

    public void deleteOrderByID(Long id){
        orderTotal.deleteOrderById(id);
    }

    public void saveOrder(Order order){
        orderTotal.saveOrder(order);
    }

}
