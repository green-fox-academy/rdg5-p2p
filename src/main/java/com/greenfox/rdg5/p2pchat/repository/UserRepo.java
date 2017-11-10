package com.greenfox.rdg5.p2pchat.repository;

import com.greenfox.rdg5.p2pchat.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User,Long> {


}