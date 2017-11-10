package com.greenfox.rdg5.p2pchat.controller;

import com.greenfox.rdg5.p2pchat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chat")
public class UserController {

  @Autowired
  UserRepo repo;

  @RequestMapping(value="/")
  public String list(Model model){
  model.addAttribute("user",repo.findAll());
  return "chat";
  }
}
