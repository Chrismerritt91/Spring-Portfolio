package com.example.springportfolio.repositories;

import com.example.springportfolio.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
