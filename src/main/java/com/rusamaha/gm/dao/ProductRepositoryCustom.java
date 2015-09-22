package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.ProductBase;
import com.rusamaha.gm.model.ProductColor;
import com.rusamaha.gm.model.ProductSize;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mary on 15.03.2015.
 */

public interface ProductRepositoryCustom {
    public Long mySave(String name, String knitTechnology, Long categoryID, Boolean availability, List<ProductSize> productSizes, List<ProductColor> colors);
}
