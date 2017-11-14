package com.greenfox.rdg5.p2pchat.service;

import com.greenfox.rdg5.p2pchat.model.Log;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestHandler {

  public boolean checkLogLevel() {
    return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO");
  }

  public void printErrorLog(HttpServletRequest request) {
    Log log = new Log(request);
    log.setLogLevel("ERROR");
    String logMessage = log.toString();
    System.err.println(logMessage);
  }

  public void printNormalLog(HttpServletRequest request) {
    if (checkLogLevel()) {
      Log log = new Log(request);
      String logMessage = log.toString();
      System.out.println(logMessage);
    }
  }

}