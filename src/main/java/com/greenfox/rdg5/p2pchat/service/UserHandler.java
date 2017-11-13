package com.greenfox.rdg5.p2pchat.service;

import com.greenfox.rdg5.p2pchat.model.User;
import com.greenfox.rdg5.p2pchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

  private User onlineUser;

  public User getActiveUser() {
    return onlineUser;
  }

  public void setOnline(User onlineUser) {
    this.onlineUser = onlineUser;
  }

  @Autowired
  UserRepository userRepository;

  public void addChatUser(String username) {
    User chatUser = new User(username);
    userRepository.save(chatUser);
  }

  public boolean checkIfUserExists(String username) {
    boolean exists = false;
    for (User user : userRepository.findAll()) {
      if (user.getName().equals(username)) {
        exists = true;
      }
    }
    return exists;
  }


  public void saveUser(User user) {
    userRepository.save(user);
  }

}