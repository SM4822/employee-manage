package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.EmployeeRepository;
import com.pack.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(UUID id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                	existingEmployee.setEmpName(updatedEmployee.getEmpName());
                	existingEmployee.setEmail(updatedEmployee.getEmail());
                    existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                    existingEmployee.setAddress(updatedEmployee.getAddress());
                    existingEmployee.setContactInfo(updatedEmployee.getContactInfo());
                    existingEmployee.setPersonalInfo(updatedEmployee.getPersonalInfo());
                    existingEmployee.setAdditionalPhoneNumbers(updatedEmployee.getAdditionalPhoneNumbers());
                    existingEmployee.setAdditionalEmailAddresses(updatedEmployee.getAdditionalEmailAddresses());
                    return employeeRepository.save(existingEmployee);
                });
    }

    public void deleteById(UUID id) {
    	employeeRepository.deleteById(id);
    }
}

