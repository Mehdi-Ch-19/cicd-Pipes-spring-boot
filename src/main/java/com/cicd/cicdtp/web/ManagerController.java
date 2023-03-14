package com.cicd.cicdtp.web;

import com.cicd.cicdtp.entity.Manager;
import com.cicd.cicdtp.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager){
        Manager adduser = managerService.adduser(manager);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteManager(@PathVariable Long userId){
        try {

            managerService.deleteUser(userId);
            return ResponseEntity.ok("delete user with succes");
        }catch (RuntimeException exception){
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Manager> allManagers(){
        return managerService.allUsers();
    }
    @GetMapping("{userId}")
    public ResponseEntity<Manager> getById(@PathVariable Long userId){
      /*  try {
            Manager manager = userService.getbyId(userId);
            return new ResponseEntity<>(manager,HttpStatus.OK);
        }catch (RuntimeException exception){
            return  ResponseEntity.notFound().build();
        }*/
        Manager manager = managerService.getbyId(userId);
        return new ResponseEntity<>(manager,HttpStatus.OK);
    }

}
