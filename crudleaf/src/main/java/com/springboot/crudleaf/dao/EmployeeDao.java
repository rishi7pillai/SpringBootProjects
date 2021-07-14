package com.springboot.crudleaf.dao;

import com.springboot.crudleaf.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeInfo,Long> {

}
