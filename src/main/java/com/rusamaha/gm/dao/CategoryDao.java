package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
* Created by Mary on 22.02.2015.
*/

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
}
