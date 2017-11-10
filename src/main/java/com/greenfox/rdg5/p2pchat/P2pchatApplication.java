package com.greenfox.rdg5.p2pchat;

import com.greenfox.rdg5.p2pchat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2pchatApplication {
  @Autowired
  UserRepo repo;

  public static void main(String[] args) {
    SpringApplication.run(P2pchatApplication.class, args);
  }
}
