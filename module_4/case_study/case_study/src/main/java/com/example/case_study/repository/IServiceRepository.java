package com.example.case_study.repository;

import com.example.case_study.model.FuramaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<FuramaService,Long> {
}
