package com.greenfox.rdg5.p2pchat.controller;

import com.greenfox.rdg5.p2pchat.model.Message;
import com.greenfox.rdg5.p2pchat.repository.LogRepository;
import com.greenfox.rdg5.p2pchat.repository.MessageRepository;
import com.greenfox.rdg5.p2pchat.repository.UserRepository;
import com.greenfox.rdg5.p2pchat.service.MessageHandler;
import com.greenfox.rdg5.p2pchat.service.RequestHandler;
import com.greenfox.rdg5.p2pchat.service.UserHandler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatAppController {

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  MessageHandler messageHandler;

  @Autowired
  RequestHandler handler;

  @Autowired
  LogRepository repo;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserHandler userHandler;


  @GetMapping(value = "/")
  public String loadMain(HttpServletRequest request, Model model) {
    handler.printNormalLog(request);
    if (userHandler.getActiveUser() == null) {
      return "user";
    } else {
      model.addAttribute("activeUser", userHandler.getActiveUser());
      model.addAttribute("messages", messageHandler.listMessages());
      return "main";
    }
  }

  @GetMapping(value = "/enter")
  public String loadEnter() {
    return "user";
  }

  @GetMapping(value = "/enter/add")
  public String addUser(@RequestParam(value = "username", required = true) String username,
      HttpServletRequest request, Model model) {
    if (username.equals("")) {
      model.addAttribute("noUsername", username);
      handler.printErrorLog(request);
      return "user";
    } else if (userHandler.checkIfUserExists(username)) {
      userHandler.setActiveUser(userHandler.getUserFromDatabaseByName(username));
      return "redirect:/";
    } else {
      userHandler.addChatUser(username);
      userHandler.setActiveUser(userHandler.getUserFromDatabaseByName(username));
      handler.printErrorLog(request);
      return "redirect:/";
    }
  }

  @GetMapping(value = "/{id}/update")
  public String updateUser(@PathVariable(value = "id", required = true) Long id,
      @RequestParam(value = "username", required = true) String username,
      HttpServletRequest request, Model model) {
    if (username.equals("")) {
      model.addAttribute("noUsername", username);
      model.addAttribute("activeUser", userHandler.getActiveUser());
      handler.printErrorLog(request);
      return "main";
    } else if (userHandler.checkIfUserExists(username)) {
      model.addAttribute("existingUsername", true);
      model.addAttribute("activeUser", userHandler.getActiveUser());
      return "main";
    } else {
      userHandler.getActiveUser().setUsername(username);
      userHandler.saveUser(userHandler.getActiveUser());
    }
    return "redirect:/";
  }

  @GetMapping("/writemessage")
  public String writeMessage(@RequestParam(value = "text") String text,
      HttpServletRequest request) {
    messageHandler.addMessage(new Message(userHandler.getActiveUser().getUsername(), text));
    handler.printNormalLog(request);
    return "redirect:/";
  }


}


