package com.greenfox.rdg5.p2pchat.repository;

import com.greenfox.rdg5.p2pchat.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



  User findUserByUsername(String username);

  User findUserById(Long id);
}

