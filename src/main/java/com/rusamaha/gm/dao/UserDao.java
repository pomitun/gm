package com.rusamaha.gm.dao;

import com.rusamaha.gm.model.User;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by Mary on 21.02.2015.
*/
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    @Query("select username from User")
    public List<String> getLogins();
}
