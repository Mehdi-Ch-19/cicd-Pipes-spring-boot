package com.cicd.cicdtp;

import com.cicd.cicdtp.entity.Manager;
import com.cicd.cicdtp.service.ManagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CicdtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CicdtpApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(ManagerService service){
        return args -> {
            service.adduser(Manager.builder()
                            .name("mehdi")
                            .password("haha")
                            .email("mehdi@gmail.com")
                    .build());
        };
    }

}
