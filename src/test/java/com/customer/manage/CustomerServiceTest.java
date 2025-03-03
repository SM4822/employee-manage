//package com.customer.manage;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.argThat;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.pack.dao.EmployeeRepository;
//import com.pack.entity.Employee;
//import com.pack.service.EmployeeService;
//
//public class CustomerServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeService employeeService;
//
//    private Employee employee;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        employee = new Employee();
//        employee.setId(UUID.randomUUID());
//        employee.setName("John Doe");
//        employee.setEmail("john.doe@example.com");
//        employee.setPhoneNumber("123-456-7890");
//    }
//
//    @Test
//    public void testFindAll() {
//        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
//
//        List<Employee> customers = employeeService.findAll();
//        assertNotNull(customers);
//        assertEquals(1, customers.size());
//        verify(employeeRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testFindById() {
//        UUID id = employee.getId();
//        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//
//        Optional<Employee> foundCustomer = employeeService.findById(id);
//        assertTrue(foundCustomer.isPresent());
//        assertEquals(employee.getName(), foundCustomer.get().getName());
//        verify(employeeRepository, times(1)).findById(id);
//    }
//
//    @Test
//    public void testFindByEmail() {
//        String email = employee.getEmail();
//        when(employeeRepository.findByEmail(email)).thenReturn(Optional.of(employee));
//
//        Optional<Employee> foundCustomer = employeeService.findByEmail(email);
//        assertTrue(foundCustomer.isPresent());
//        assertEquals(employee.getEmail(), foundCustomer.get().getEmail());
//        verify(employeeRepository, times(1)).findByEmail(email);
//    }
//
//    @Test
//    public void testFindByPhoneNumber() {
//        String phoneNumber = employee.getPhoneNumber();
//        when(employeeRepository.findByPhoneNumber(phoneNumber)).thenReturn(Optional.of(employee));
//
//        Optional<Employee> foundCustomer = employeeService.findByPhoneNumber(phoneNumber);
//        assertTrue(foundCustomer.isPresent());
//        assertEquals(employee.getPhoneNumber(), foundCustomer.get().getPhoneNumber());
//        verify(employeeRepository, times(1)).findByPhoneNumber(phoneNumber);
//    }
//
//    @Test
//    public void testSave() {
//        when(employeeRepository.save(employee)).thenReturn(employee);
//
//        Employee savedEmployee = employeeService.save(employee);
//        assertNotNull(savedEmployee);
//        assertEquals(employee.getName(), savedEmployee.getName());
//        verify(employeeRepository, times(1)).save(employee);
//    }
//
//    @Test
//    public void testUpdateCustomer() {
//        UUID id = employee.getId();
//        Employee updatedCustomer = new Employee();
//        updatedCustomer.setId(id);
//        updatedCustomer.setName("Jane Smith");
//        updatedCustomer.setEmail("jane.smith@example.com");
//        updatedCustomer.setPhoneNumber("098-765-4321");
//
//        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
//        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        Optional<Employee> result = employeeService.updateEmployee(id, updatedCustomer);
//
//        assertTrue(result.isPresent());
//        assertEquals("Jane Smith", result.get().getName());
//        assertEquals("jane.smith@example.com", result.get().getEmail());
//        assertEquals("098-765-4321", result.get().getPhoneNumber());
//
//        verify(employeeRepository, times(1)).save(argThat(argument ->
//                argument.getName().equals("Jane Smith") &&
//                        argument.getEmail().equals("jane.smith@example.com") &&
//                        argument.getPhoneNumber().equals("098-765-4321")
//        ));
//    }
//
//
//
//    @Test
//    public void testDeleteById() {
//        UUID id = employee.getId();
//        doNothing().when(employeeRepository).deleteById(id);
//
//        employeeService.deleteById(id);
//        verify(employeeRepository, times(1)).deleteById(id);
//    }
//}
