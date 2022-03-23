package com.example.case_study.repository;

import com.example.case_study.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education,Long> {
}
