package com.example.case_study.repository;

import com.example.case_study.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Long> {
}
