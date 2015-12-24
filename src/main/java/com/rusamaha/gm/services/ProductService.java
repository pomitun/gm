package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.ProductDao;
import com.rusamaha.gm.model.ProductBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
* Created by Mary on 23.02.2015.
*/
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public ProductBase saveOrUpdate(ProductBase product){

        if (product.getId() != null) {
            ProductBase dbProduct = productDao.findOne(product.getId());

            dbProduct.setName(product.getName());
            dbProduct.setKnitTechnology(product.getKnitTechnology());
            dbProduct.setAvailability(product.getAvailability());
            dbProduct.setCategory(product.getCategory());

            Long id = productDao.mySave(
                    dbProduct.getName(),
                    dbProduct.getKnitTechnology(),
                    dbProduct.getCategory().getId(),
                    dbProduct.getAvailability(),
                    dbProduct.getProductSizes(),
                    dbProduct.getProductColors()
            );
            return productDao.findOne(id);

        } else {
            Long id = productDao.mySave(product.getName(),
                    product.getKnitTechnology(),
                    product.getCategory().getId(),
                    product.getAvailability(),
                    product.getProductSizes(),
                    product.getProductColors()
            );
            return productDao.findOne(id);
        }
    }

    public ProductBase findById(Long id){
        return productDao.findOne(id);
    }

    public Iterable<ProductBase> getAllProducts(){
        return productDao.findAll();
    }

    public List<ProductBase> findByName(String name){
        return productDao.findByName(name);
    }
}
