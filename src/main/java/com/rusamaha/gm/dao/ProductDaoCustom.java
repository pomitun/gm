package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.ProductColor;
import com.rusamaha.gm.model.ProductSize;

import java.util.List;

/**
 * Created by rusamaha on 23/12/15.
 */
public interface ProductDaoCustom {
    public Long mySave(String name, String knitTechnology, Long categoryID, Boolean availability,
                      List<ProductSize> productSizes, List<ProductColor> productColors );


}
