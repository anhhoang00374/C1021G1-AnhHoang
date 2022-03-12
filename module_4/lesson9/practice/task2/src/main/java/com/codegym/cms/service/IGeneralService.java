package com.codegym.cms.service;

import com.codegym.cms.DuplicateEmailException;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
