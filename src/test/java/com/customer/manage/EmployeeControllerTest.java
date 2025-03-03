//package com.customer.manage;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.pack.controller.EmployeeController;
//import com.pack.entity.Employee;
//import com.pack.service.EmployeeService;
//
//import java.util.Optional;
//import java.util.UUID;
//import java.util.Arrays;
//
//@WebMvcTest(EmployeeController.class)
//public class EmployeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeService employeeService;
//
//    private Employee employee;
//
//    @BeforeEach
//    public void setUp() {
//    	employee = new Employee();
//    	employee.setId(UUID.randomUUID());
//    	employee.setName("John Doe");
//        employee.setEmail("john.doe@example.com");
//        employee.setPhoneNumber("123-456-7890");
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testGetAllCustomers() throws Exception {
//        when(employeeService.findAll()).thenReturn(Arrays.asList(employee));
//
//        mockMvc.perform(get("/api/customers")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testGetCustomerById() throws Exception {
//        UUID id = employee.getId();
//        when(employeeService.findById(id)).thenReturn(Optional.of(employee));
//
//        mockMvc.perform(get("/api/customers/" + id)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testGetCustomerByEmail() throws Exception {
//        String email = employee.getEmail();
//        when(employeeService.findByEmail(email)).thenReturn(Optional.of(employee));
//
//        mockMvc.perform(get("/api/customers/search")
//                        .param("email", email)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testGetCustomerByPhoneNumber() throws Exception {
//        String phoneNumber = employee.getPhoneNumber();
//        when(employeeService.findByPhoneNumber(phoneNumber)).thenReturn(Optional.of(employee));
//
//        mockMvc.perform(get("/api/customers/search")
//                        .param("phoneNumber", phoneNumber)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testCreateCustomer() throws Exception {
//        when(employeeService.save(any(Employee.class))).thenReturn(employee);
//
//        mockMvc.perform(post("/api/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"phoneNumber\":\"123-456-7890\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testUpdateCustomer() throws Exception {
//        UUID id = employee.getId();
//        Employee updatedEmployee = new Employee();
//        updatedEmployee.setId(id);
//        updatedEmployee.setName("Jane Smith");
//        updatedEmployee.setEmail("jane.smith@example.com");
//        updatedEmployee.setPhoneNumber("098-765-4321");
//
//        when(employeeService.findById(id)).thenReturn(Optional.of(employee));
//        when(employeeService.updateEmployee(eq(id), any(Employee.class))).thenReturn(Optional.of(updatedEmployee));
//
//        mockMvc.perform(put("/api/customers/" + id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"Jane Smith\",\"email\":\"jane.smith@example.com\",\"phoneNumber\":\"098-765-4321\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Jane Smith"))
//                .andExpect(jsonPath("$.email").value("jane.smith@example.com"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testDeleteCustomer() throws Exception {
//        UUID id = employee.getId();
//        // Ensure the customer is found when findById is called
//        when(employeeService.findById(id)).thenReturn(Optional.of(employee));
//
//        // Simulate successful deletion
//        doNothing().when(employeeService).deleteById(id);
//
//        mockMvc.perform(delete("/api/customers/" + id)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//}
