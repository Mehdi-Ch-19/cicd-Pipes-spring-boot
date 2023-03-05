package com.cicd.cicdtp.repository;

import com.cicd.cicdtp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
}
