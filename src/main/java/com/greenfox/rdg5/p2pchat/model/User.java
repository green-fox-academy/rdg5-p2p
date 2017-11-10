package com.greenfox.rdg5.p2pchat.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String name;


  public User(String name) {
    this.name = name;
  }

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
