package com.codegym.cms.repository;

import com.codegym.cms.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
