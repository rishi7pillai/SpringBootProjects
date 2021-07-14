package com.springboot.crudleaf.service;

import com.springboot.crudleaf.dao.EmployeeDao;
import com.springboot.crudleaf.entity.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<EmployeeInfo> getAllEmployee(){
        return employeeDao.findAll();
    }

    public void saveEmployee(EmployeeInfo employeeInfo){
        this.employeeDao.save(employeeInfo);
    }

    public EmployeeInfo getEmployeeById(long id){
        Optional<EmployeeInfo> optional = employeeDao.findById(id);
        EmployeeInfo employeeInfo = null;
        if(optional.isPresent()){
            employeeInfo = optional.get();
        }
        else{
            throw new RuntimeException("Employee not found !!");
        }
        return employeeInfo;
    }

    public void deleteEmployee(long id) {
        this.employeeDao.deleteById(id);
    }
}
