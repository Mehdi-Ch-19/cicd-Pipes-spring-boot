package com.cicd.cicdtp.service;

import com.cicd.cicdtp.entity.Manager;
import com.cicd.cicdtp.repository.ManagerRepo;
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
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {


    @Mock
    ManagerRepo managerRepo;

    @InjectMocks
    private ManagerService managerService;
    private Manager manager;
    private Manager manager2;


    @BeforeEach
    void setUp() {
         manager = Manager.builder()
                .id(1L)
                .name("mounir")
                .email("mounir@gmail.com")
                .password("123")
                .build();
        manager2 = Manager.builder()
                .id(2L)
                .name("said")
                .email("saidd@gmail.com")
                .password("5223")
                .build();
    }

    @Test
    void adduser() {

        when(managerRepo.save(any(Manager.class))).thenReturn(manager);
        Manager newManager = managerService.adduser(manager);
        assertNotNull(manager);
        assertThat(newManager.getName(),equalTo("mounir"));
    }

    @Test
    void deleteUser() {

        Long userid = 1L;
        when(managerRepo.findById(anyLong())).thenReturn(Optional.of(manager));
        doNothing().when(managerRepo).delete(any(Manager.class));
        managerService.deleteUser(userid);
        verify(managerRepo,times(1)).delete(manager);
    }

    @Test
    void getbyId() {
        when(managerRepo.findById(anyLong())).thenReturn(Optional.of(manager2));
        Manager existManger = managerService.getbyId(manager2.getId());
        assertNotNull(existManger);
        assertThat(existManger.getId(),notNullValue(null));
    }

    @Test
    void allUsers() {
        List<Manager> managerList = new ArrayList<>();
        managerList.add(Manager.builder()
                .id(1L)
                        .name("mounir")
                        .email("mounir@gmail.com")
                        .password("123")
                .build());
        managerList.add(Manager.builder()
                        .id(2L)
                .name("said")
                .email("said@gmail.com")
                .password("523")
                .build());


        when(managerRepo.findAll()).thenReturn(managerList);
        List<Manager> list = managerService.allUsers();
        assertEquals(2,list.size());
        assertNotNull(list);
     }
}