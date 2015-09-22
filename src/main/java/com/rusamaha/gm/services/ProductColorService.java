package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.ProductColorRepository;
import com.rusamaha.gm.model.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mary on 11.05.2015.
 */
@Service
@Transactional
public class ProductColorService {

    @Autowired
    private ProductColorRepository productColorDao;

    public Iterable<ProductColor> getAllProductColors(){
        return productColorDao.findAll();
    }
}
