package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.UserDao;
import com.rusamaha.gm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
* Created by Mary on 20.02.2015.
*/

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao users;

    public Iterable<User> getAllUsers(){
        return users.findAll();
    }

    public Iterable<String> getLogins() {
        return users.getLogins();
    }

    public User findById(Long id){
        return users.findOne(id); }

    public void save(User user){
        users.save(user);
    };
}

