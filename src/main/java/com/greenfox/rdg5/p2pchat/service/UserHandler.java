package com.greenfox.rdg5.p2pchat.service;

import com.greenfox.rdg5.p2pchat.model.User;
import com.greenfox.rdg5.p2pchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {


  private User activeUser;

  public User getActiveUser() {
    return activeUser;
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }

  @Autowired
  UserRepository chatUserRepository;

  public void addChatUser(String username) {
    User chatUser = new User(username);
    chatUserRepository.save(chatUser);
  }

  public boolean checkIfUserExists(String username) {
    boolean exists = false;
    for (User user : chatUserRepository.findAll()) {
      if (user.getUsername().equals(username)) {
        exists = true;
      }
    }
    return exists;
  }

  public User getUserFromDatabaseByName(String username) {
    return chatUserRepository.findUserByUsername(username);
  }

  public User getUserFromDatabaseById(Long id) {
    return chatUserRepository.findUserById(id);
  }

  public void saveUser(User user) {
    chatUserRepository.save(user);
  }

}