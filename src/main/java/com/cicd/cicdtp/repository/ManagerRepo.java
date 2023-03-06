package com.cicd.cicdtp.repository;

import com.cicd.cicdtp.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long>  {
}
