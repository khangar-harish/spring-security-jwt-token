package com.hash.springbootsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

}
