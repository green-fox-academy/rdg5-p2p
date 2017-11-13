package com.greenfox.rdg5.p2pchat.controller;

import com.greenfox.rdg5.p2pchat.model.Log;
import com.greenfox.rdg5.p2pchat.repository.LogRepository;
//import com.greenfox.rdg5.p2pchat.service.RequestHandler;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

//  @Autowired
//  RequestHandler handler;

  @Autowired
  LogRepository repo;


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

}
