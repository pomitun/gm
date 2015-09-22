package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.ProductSizeRepository;
import com.rusamaha.gm.model.ProductSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mary on 11.05.2015.
 */
@Service
@Transactional
public class ProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeDao;

    public Iterable<ProductSize> getAllProductSizes(){
        return productSizeDao.findAll();
    }
}
