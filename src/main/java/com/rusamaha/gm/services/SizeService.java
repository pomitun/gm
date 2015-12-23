package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.SizeDao;
import com.rusamaha.gm.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mary on 15.03.2015.
 */
@Service
@Transactional
public class SizeService {

    @Autowired
    private SizeDao sizeDao;

    public Iterable<Size> getAllSizes(){
        return sizeDao.findAll();
    }
}
