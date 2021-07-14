package com.springboot.crudleaf.controller;

import com.springboot.crudleaf.entity.EmployeeInfo;
import com.springboot.crudleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        EmployeeInfo employeeInfo=new EmployeeInfo();
        model.addAttribute("employee",employeeInfo);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeInfo employeeInfo){
        //save employee to database
        employeeService.saveEmployee(employeeInfo);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id,Model model){
        //get employee from the service
        EmployeeInfo employeeInfo = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employeeInfo);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
     public String deleteEmployee(@PathVariable(value = "id") long id){
            //call delete employee method
            employeeService.deleteEmployee(id);
            return "redirect:/" ;
        }
}
