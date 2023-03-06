package com.cicd.cicdtp.service;

import com.cicd.cicdtp.entity.Manager;
import com.cicd.cicdtp.repository.ManagerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerService {
    private final ManagerRepo managerRepo;

    public Manager adduser(Manager manager){
        return this.managerRepo.save(manager);
    }
    public void deleteUser(Long id){
        Manager manager = managerRepo.findById(id).orElseThrow(()->new RuntimeException("manager not found"));
        managerRepo.delete(manager);
    }
    public Manager getbyId(Long id){
        return managerRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }
    public List<Manager> allUsers(){
        return managerRepo.findAll();
    }
}
