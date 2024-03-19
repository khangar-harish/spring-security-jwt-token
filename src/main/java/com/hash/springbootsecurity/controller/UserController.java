package com.hash.springbootsecurity.controller;

import com.hash.springbootsecurity.entity.UserInfo;
import com.hash.springbootsecurity.repository.UserRepository;
import com.hash.springbootsecurity.service.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserInfoDetails userInfoDetails;
//
//    @PostMapping
//    public String addUser(@RequestBody UserInfo userInfo){
//        return userInfoDetails.addUser(userInfo);
//    }
}
