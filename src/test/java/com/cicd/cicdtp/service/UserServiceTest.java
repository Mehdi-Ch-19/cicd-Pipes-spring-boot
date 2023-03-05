package com.cicd.cicdtp.service;

import com.cicd.cicdtp.entity.User;
import com.cicd.cicdtp.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    UserRepo userRepo;

    @InjectMocks
    private UserService userService;
    private User user;
    private User user2;


    @BeforeEach
    void setUp() {
         user = User.builder()
                .id(1L)
                .name("mounir")
                .email("mounir@gmail.com")
                .password("123")
                .build();
        user2 = User.builder()
                .id(2L)
                .name("said")
                .email("said@gmail.com")
                .password("523")
                .build();
    }

    @Test
    void adduser() {

        when(userRepo.save(any(User.class))).thenReturn(user);
        User newUser = userService.adduser(user);
        assertNotNull(user);
        assertThat(newUser.getName(),equalTo("mounir"));
    }

    @Test
    void deleteUser() {
        User user = User.builder()
                .id(1L)
                .name("mounir")
                .email("mounir@gmail.com")
                .password("123")
                .build();
        Long userid = 1L;
        when(userRepo.findById(anyLong())).thenReturn(Optional.of(user));
        doNothing().when(userRepo).delete(any(User.class));
        userService.deleteUser(userid);
        verify(userRepo,times(1)).delete(user);
    }

    @Test
    void getbyId() {
    }

    @Test
    void allUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(User.builder()
                .id(1L)
                        .name("mounir")
                        .email("mounir@gmail.com")
                        .password("123")
                .build());
        userList.add(User.builder()
                        .id(2L)
                .name("said")
                .email("said@gmail.com")
                .password("523")
                .build());


        when(userRepo.findAll()).thenReturn(userList);
        List<User> list = userService.allUsers();
        assertEquals(2,list.size());
        assertNotNull(list);
     }
}