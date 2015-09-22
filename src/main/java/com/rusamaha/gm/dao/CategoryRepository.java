package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Category;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
* Created by Mary on 22.02.2015.
*/

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
