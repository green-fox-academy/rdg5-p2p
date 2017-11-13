package com.greenfox.rdg5.p2pchat.controller;

import com.greenfox.rdg5.p2pchat.model.Log;
import com.greenfox.rdg5.p2pchat.model.User;
import com.greenfox.rdg5.p2pchat.repository.LogRepository;
//import com.greenfox.rdg5.p2pchat.service.RequestHandler;
import com.greenfox.rdg5.p2pchat.repository.UserRepository;
import com.greenfox.rdg5.p2pchat.service.UserHandler;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatAppController {

//  @Autowired
//  RequestHandler handler;

  @Autowired
  LogRepository repo;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserHandler userHandler;


  @GetMapping(value = "/")
  public String loadChat(HttpServletRequest request, Model model) {
    List<Log> list = new ArrayList<>();
    repo.save(
        new Log(request.getRequestURI(), request.getMethod(), "INFO", request.getQueryString()));
    for (Log entry : repo.findAll()) {
      list.add(entry);
    }
    model.addAttribute("list", list);
    return "chat";
  }


  @GetMapping(value = "/enter")
  public String mainEnter() {
    return "user";
  }


  @GetMapping(value = "/enter/add")
  public String addUser(@RequestParam(value = "username", required = true) String username,
      HttpServletRequest request, Model model) {
    userHandler.addChatUser(username);
    return "redirect:/";
  }

}
