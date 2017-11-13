//package com.greenfox.rdg5.p2pchat.service;
//
//import com.greenfox.rdg5.p2pchat.model.Log;
//import com.greenfox.rdg5.p2pchat.repository.LogRepository;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RequestHandler {
//
//  @Autowired
//  LogRepository repo;
//
//  public void printLog(HttpServletRequest request) {
//    Log log = new Log(request);
//    String print = log.getLog().toString();
//    System.out.println(print);
//    repo.save(log);
//  }
//}
