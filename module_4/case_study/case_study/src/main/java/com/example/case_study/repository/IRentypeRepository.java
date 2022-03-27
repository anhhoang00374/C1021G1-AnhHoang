package com.example.case_study.repository;

import com.example.case_study.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentypeRepository extends JpaRepository<RentType,Long> {
}
