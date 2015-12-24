package com.rusamaha.gm.dao.impl;

import com.rusamaha.gm.dao.ProductDao;
import com.rusamaha.gm.dao.ProductDaoCustom;
import com.rusamaha.gm.model.ProductBase;
import com.rusamaha.gm.model.ProductColor;
import com.rusamaha.gm.model.ProductSize;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by Mary on 12.03.2015.
 */
public class ProductDaoImpl implements ProductDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long mySave(String name, String knitTechnology, Long categoryID, Boolean availability,
                       List<ProductSize> productSizes, List<ProductColor> productColors ){
        System.out.println("____________________________________________________________________________________");
        Session session = em.unwrap(Session.class);
        Long id = null;

        CallableStatement callableStatement = null;
        Connection dbConnection = null;

        String product_ins_sql = "{call PRODUCT_INS(?,?,?,?,?)}";

        dbConnection = em.unwrap(SessionImpl.class).connection();

        try {
            callableStatement = dbConnection.prepareCall(product_ins_sql);

            callableStatement.setString(1, name);
            callableStatement.setString(2, knitTechnology);
            callableStatement.setLong(3, categoryID);
            callableStatement.setBoolean(4, availability);
            callableStatement.registerOutParameter(5, Types.BIGINT);

            callableStatement.executeUpdate();
            id = callableStatement.getLong(5);


            for(ProductColor productColor: productColors) {
                Query product_color_ins = session.createSQLQuery("INSERT INTO PRODUCT_COLOR (COLOR_COLOR_ID, PRODUCT_PRODUCT_BASE_ID, IMAGE) VALUES (:param1, :param2, :param3)")
                        .setParameter("param1", productColor.getColor().getId())
                        .setParameter("param2", id)
                        .setParameter("param3", productColor.getImage());
                product_color_ins.executeUpdate();
            }


            for(ProductSize productSize: productSizes) {
                Query product_size_ins = session.createSQLQuery("INSERT INTO PRODUCT_SIZE (CUSTOM_SIZE_SIZE_ID, PRODUCT_PRODUCT_BASE_ID) VALUES (:param1, :param2)")
                        .setParameter("param1", productSize.getCustomSize().getId())
                        .setParameter("param2", id);
                product_size_ins.executeUpdate();
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        finally {
             return id;
//            if (callableStatement != null) {
//                callableStatement.close();
//            }
//
//            if (dbConnection != null) {
//                dbConnection.close();
//            }

        }

    }

    public List<ProductBase> findByName(String name){
        Session session = em.unwrap(Session.class);
        System.out.println(name);
        return session.createCriteria(ProductBase.class).add(Restrictions.eq("name", "%" + name + "%")).list();
    }



//        Query query = session.createSQLQuery("CALL PRODUCT_INS(:name, :knitTechnology, :categoryID, :availability, :id)")
//                .setParameter("name", name)
//                .setParameter("knitTechnology", knitTechnology)
//                .setParameter("categoryID", categoryID)
//                .setParameter("availability", availability)
//                .setParameter("id", id);
//
//        //int exRows = query.executeUpdate();
//        System.out.println("query.getMaxResults(): " + query.getMaxResults() );
//        System.out.println("query.list(): " + query.list());
//        //List<ProductBase> list = query.list();

}
