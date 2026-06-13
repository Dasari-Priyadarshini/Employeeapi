package com.priya.employeeapi.service;

import com.priya.employeeapi.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO dto);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);

    void deleteEmployee(Long id);
}