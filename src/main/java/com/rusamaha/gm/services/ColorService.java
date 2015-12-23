package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.ColorDao;
import com.rusamaha.gm.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Mary on 15.03.2015.
 */
@Service
@Transactional
public class ColorService {

    @Autowired
    private ColorDao colorDao;

    public Iterable<Color> getAllColors(){
        return colorDao.findAll();
    }
}

