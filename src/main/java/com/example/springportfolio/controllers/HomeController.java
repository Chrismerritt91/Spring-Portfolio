package com.example.springportfolio.controllers;

import com.example.springportfolio.model.Message;
import com.example.springportfolio.model.User;
import com.example.springportfolio.repositories.MessageRepository;
import com.example.springportfolio.repositories.UserRepository;
import com.example.springportfolio.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private EmailService emailService;

    public HomeController(MessageRepository messageDao, UserRepository userDao, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.messageDao = messageDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String Home(Model model) {
        model.addAttribute("message", new Message());
        return "index";
    }

    @PostMapping("/messages/create")
    public String insertMessage(@ModelAttribute Message message){
        User user = userDao.findById(2L).get();
        message.setUser(user);
        messageDao.save(message);
        emailService.prepareAndSend(user, "New Message");
        return "redirect:/";
    }

//    @PostMapping("/create-user")
//    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/";
//    }

}
