package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);

}
