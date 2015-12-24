package com.rusamaha.gm.dao.impl;

import com.rusamaha.gm.dao.OrderTotalDaoCustom;
import com.rusamaha.gm.model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.Date;

/**
 * Created by Mary on 24.12.2015.
 */
public class OrderTotalDaoImpl implements OrderTotalDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveOrder(Order order){
        Session session = em.unwrap(Session.class);

        Long orderTotalId = null;

        CallableStatement callableStatement = null;
        Connection dbConnection = null;

        String order_total_ins_sql = "{call ORDER_TOTAL_INS(?,?,?,?)}";

        dbConnection = em.unwrap(SessionImpl.class).connection();

        try {
            callableStatement = dbConnection.prepareCall(order_total_ins_sql);

            callableStatement.setTimestamp(1, (Timestamp) new Date());
            callableStatement.setLong(2, order.getMaster().getId());
            callableStatement.setInt(3, order.getTotalCost());
            callableStatement.registerOutParameter(5, Types.BIGINT);

            callableStatement.executeUpdate();
            orderTotalId = callableStatement.getLong(5);
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    public void deleteOrderById(Long id){

//        CallableStatement callableStatement = null;
//        Connection dbConnection = null;
//
//        String order_total_del_sql = "{call ORDER_TOTAL_DEL(?)}";
//        dbConnection = em.unwrap(SessionImpl.class).connection();
//
//        try {
//            callableStatement = dbConnection.prepareCall(order_total_del_sql);
//
//            callableStatement.setLong(1, id);
//
//            callableStatement.executeUpdate();
//
//        } catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//        }

        Session session = em.unwrap(Session.class);

        Query query = session.createSQLQuery("DELETE FROM ORDER_TOTAL WHERE ORDER_TOTAL_ID = :id")
                .setParameter("id", id);

        query.executeUpdate();

    }
}


