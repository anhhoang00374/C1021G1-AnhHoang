package com.example.case_study.repository;

import com.example.case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
