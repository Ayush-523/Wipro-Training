package com.company.service;

import com.company.bean.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);

  public Employee updateEmployee(Integer id , Employee employee);
  public void deleteEmployee(Integer id);
   public Optional<Employee> getEmployeeById(Integer id);
   public List<Employee> getAllEmployees();


}
