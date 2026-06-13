package com.priya.employeeapi.controller;

import com.priya.employeeapi.dto.EmployeeDTO;
import com.priya.employeeapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(
            EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO>
    createEmployee(
            @Valid
            @RequestBody EmployeeDTO dto) {

        return new ResponseEntity<>(
                service.createEmployee(dto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>>
    getAllEmployees() {

        return ResponseEntity.ok(
                service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO>
    getEmployee(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO>
    updateEmployee(
            @PathVariable Long id,
            @Valid
            @RequestBody EmployeeDTO dto) {

        return ResponseEntity.ok(
                service.updateEmployee(
                        id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deleteEmployee(
            @PathVariable Long id) {

        service.deleteEmployee(id);

        return ResponseEntity.ok(
                "Deleted Successfully");
    }
}