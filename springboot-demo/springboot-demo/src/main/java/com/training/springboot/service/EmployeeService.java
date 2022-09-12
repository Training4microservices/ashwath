package com.training.springboot.service;

import com.training.springboot.model.Employee;
import com.training.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  public double avgSalary(){
    double salTotal=0;
    for(int i=0;i<=employeeRepository.count();i++){
      salTotal=salTotal+getEmployeeById(i).getSalary();
    }
    return salTotal/employeeRepository.count();
  }
  public List getAllEmployees() {
    List employees = new ArrayList();
    employeeRepository.findAll().forEach(employee -> employees.add(employee));
    return employees;
  }

  public Employee getEmployeeById(int id) {
    return employeeRepository.findById(id).get();
  }
  public double getEmployeeSalaryById(int id) {
    return employeeRepository.findById(id).get().getSalary();
  }

  public void saveOrUpdate(Employee employee) {
    employeeRepository.save(employee);
  }

  public void delete(int id) {
    employeeRepository.deleteById(id);
  }

  public Employee updateEmployee(String name, Integer id) {
    Optional<Employee> originalEmployee = employeeRepository.findById(id);
    Employee employee = originalEmployee.get();
    employee.setName(name);
    return employeeRepository.save(employee);
  }
}