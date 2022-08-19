package com.dbsummer.practice.controller;

import com.dbsummer.practice.model.User;
import com.dbsummer.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("register")
    @ResponseBody
    public void register(@RequestBody User user) {

    }
}
