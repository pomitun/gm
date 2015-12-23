package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Color;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mary on 15.03.2015.
 */
@Repository
public interface ColorDao extends CrudRepository<Color, Long> {
}
