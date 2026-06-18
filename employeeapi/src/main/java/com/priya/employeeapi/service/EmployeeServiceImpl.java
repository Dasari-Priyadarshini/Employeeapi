package com.priya.employeeapi.service;

import com.priya.employeeapi.dto.EmployeeDTO;
import com.priya.employeeapi.entity.Employee;
import com.priya.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(
            EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDTO createEmployee(
            EmployeeDTO dto) {

        logger.info("Creating employee");

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        Employee saved =
                repository.save(employee);

        dto.setId(saved.getId());

        return dto;
    }

    @Override
    public List<EmployeeDTO>
    getAllEmployees() {

        logger.info("Fetching all employees");

        return repository.findAll()
                .stream()
                .map(emp -> {
                    EmployeeDTO dto =
                            new EmployeeDTO();

                    dto.setId(emp.getId());
                    dto.setName(emp.getName());
                    dto.setDepartment(
                            emp.getDepartment());
                    dto.setSalary(
                            emp.getSalary());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO
    getEmployeeById(Long id) {

        logger.info("Fetching employee with ID: {}", id);

        Employee emp =
                repository.findById(id)
                        .orElseThrow();

        EmployeeDTO dto =
                new EmployeeDTO();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setDepartment(
                emp.getDepartment());
        dto.setSalary(emp.getSalary());

        return dto;
    }

    @Override
    public EmployeeDTO updateEmployee(
            Long id,
            EmployeeDTO dto) {

        logger.info("Updating employee with ID: {}", id);

        Employee emp =
                repository.findById(id)
                        .orElseThrow();

        emp.setName(dto.getName());
        emp.setDepartment(
                dto.getDepartment());
        emp.setSalary(dto.getSalary());

        repository.save(emp);

        dto.setId(id);

        return dto;
    }

    @Override
    public void deleteEmployee(Long id) {

        logger.info("Deleting employee with ID: {}", id);

        repository.deleteById(id);
    }
}