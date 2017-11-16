package com.greenfox.rdg5.p2pchat.repository;

import com.greenfox.rdg5.p2pchat.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {


}
