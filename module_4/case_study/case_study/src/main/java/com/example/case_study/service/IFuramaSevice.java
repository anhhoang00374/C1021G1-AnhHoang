package com.example.case_study.service;

import com.example.case_study.model.FuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFuramaSevice {
    List<FuramaService>  findAll();
    Page<FuramaService> findAll(Pageable pageable);
    void save(FuramaService furamaService);
}
