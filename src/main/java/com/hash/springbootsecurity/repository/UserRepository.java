package com.hash.springbootsecurity.repository;

import com.hash.springbootsecurity.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String username);
}
