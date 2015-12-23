package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.ProductBase;
import com.rusamaha.gm.model.ProductColor;
import com.rusamaha.gm.model.ProductSize;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mary on 23.02.2015.
 */
@Repository
public interface ProductDao extends CrudRepository<ProductBase, Long>, ProductDaoCustom {
    Long mySave(String name, String knitTechnology, Long categoryID, Boolean availability, List<ProductSize> productSizes, List<ProductColor> colors);


}
