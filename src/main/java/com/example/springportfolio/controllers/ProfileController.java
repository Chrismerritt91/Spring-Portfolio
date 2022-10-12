package com.example.springportfolio.controllers;

import com.example.springportfolio.model.Message;
import com.example.springportfolio.model.User;
import com.example.springportfolio.repositories.MessageRepository;
import com.example.springportfolio.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileController {

    private UserRepository usersDao;
    private MessageRepository messagesDao;

    public ProfileController(UserRepository usersDao, MessageRepository messagesDao) {
        this.usersDao = usersDao;
        this.messagesDao = messagesDao;
    }

    @GetMapping("/profile")
    public String Profile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long count = messagesDao.count();
        List<Message> messages = messagesDao.findAll();
        model.addAttribute("messages", messages);
        model.addAttribute("count", count);
        model.addAttribute("user", user);
        return "profile";
    }



}
