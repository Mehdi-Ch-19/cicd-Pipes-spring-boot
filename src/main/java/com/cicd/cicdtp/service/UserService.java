package com.cicd.cicdtp.service;

import com.cicd.cicdtp.entity.User;
import com.cicd.cicdtp.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User adduser(User user){
        return this.userRepo.save(user);
    }
    public void deleteUser(Long id){
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        userRepo.delete(user);
    }
    public User getbyId(Long id){
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }
    public List<User> allUsers(){
        return userRepo.findAll();
    }
}
