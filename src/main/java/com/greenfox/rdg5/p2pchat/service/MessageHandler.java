package com.greenfox.rdg5.p2pchat.service;

import com.greenfox.rdg5.p2pchat.model.Message;
import com.greenfox.rdg5.p2pchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageHandler {

  @Autowired
  MessageRepository messageRepository;

  public void addMessage(Message msg) {
    messageRepository.save(msg);
  }

  public Iterable<Message> listMessages() {
    return messageRepository.findAll();
  }

}
