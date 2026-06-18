package com.priya.employeeapi;

import com.priya.employeeapi.entity.Employee;
import com.priya.employeeapi.repository.EmployeeRepository;
import com.priya.employeeapi.service.EmployeeServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testEmployeeRepository() {

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Priya");

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        Optional<Employee> result =
                employeeRepository.findById(1L);

        assertNotNull(result);
        assertEquals("Priya", result.get().getName());
    }
}