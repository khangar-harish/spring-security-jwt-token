package com.hash.springbootsecurity.service;

import com.hash.springbootsecurity.config.UserInfoToUserDetails;
import com.hash.springbootsecurity.entity.UserInfo;
import com.hash.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserInfoDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    public PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userRepository.findByName(username);

        return userInfo.map(UserInfoToUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with "+username));
    }

//    public String addUser(UserInfo userInfo){
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        userRepository.save(userInfo);
//        return "User Created with Id "+userInfo.getId();
//    }
}
