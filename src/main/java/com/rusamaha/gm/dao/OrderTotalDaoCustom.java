package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Order;

/**
 * Created by Mary on 24.12.2015.
 */
public interface OrderTotalDaoCustom {
    public void saveOrder(Order order);

    public void deleteOrderById(Long id);
}
