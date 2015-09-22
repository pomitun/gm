package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mary on 15.03.2015.
 */
@Repository
public interface SizeRepository extends CrudRepository<Size, Long> {
}
