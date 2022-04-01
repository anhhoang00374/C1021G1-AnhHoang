package com.example.test.repository;

import com.example.test.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<Type,Long> {
}
