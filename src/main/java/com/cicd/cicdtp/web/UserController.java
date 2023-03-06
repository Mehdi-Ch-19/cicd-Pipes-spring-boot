package com.cicd.cicdtp.web;

import com.cicd.cicdtp.entity.User;
import com.cicd.cicdtp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> adduser(@RequestBody User user){
        User adduser = userService.adduser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("delete user with succes");
        }catch (RuntimeException exception){
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{/userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId){
        try {
            User user = userService.getbyId(userId);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (RuntimeException exception){
            return  ResponseEntity.notFound().build();
        }
    }

}
