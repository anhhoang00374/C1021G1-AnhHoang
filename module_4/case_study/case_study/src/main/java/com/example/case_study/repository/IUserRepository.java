package com.example.case_study.repository;

import com.example.case_study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User,String> {
    User findByUserName(String name);
}
