package com.greenfox.rdg5.p2pchat.model;

public class State {

  String state;
  String message;

  public State(String state, String message) {
    this.state = state;
    this.message = message;
  }

  public State(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
