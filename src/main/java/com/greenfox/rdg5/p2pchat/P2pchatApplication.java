package com.greenfox.rdg5.p2pchat;

import com.greenfox.rdg5.p2pchat.model.User;
import com.greenfox.rdg5.p2pchat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2pchatApplication implements CommandLineRunner {
  @Autowired
  UserRepo repo;


  //HelloWorld!

  public static void main(String[] args) {
    SpringApplication.run(P2pchatApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repo.save(new User("pisti"));
  }
}
