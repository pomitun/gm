package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rusamaha on 23/12/15.
 */
@Repository
public interface OrderTotalDao extends CrudRepository<Order, Long> {

}
