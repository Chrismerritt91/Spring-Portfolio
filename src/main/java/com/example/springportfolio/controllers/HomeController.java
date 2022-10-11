package com.example.springportfolio.controllers;

import com.example.springportfolio.model.User;
import com.example.springportfolio.repositories.MessageRepository;
import com.example.springportfolio.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private MessageRepository messageDao;
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public HomeController(MessageRepository messageDao, UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.messageDao = messageDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String Home() {
//        model.addAttribute("user", new User());
        return "index";
    }

//    @PostMapping("/create-user")
//    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/";
//    }

}
