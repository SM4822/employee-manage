//package com.customer.manage;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.UUID;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.pack.dao.EmployeeRepository;
//import com.pack.entity.Employee;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testCreateAndGetCustomer() throws Exception {
//        // Create a new customer
//        String customerJson = "{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"phoneNumber\":\"123-456-7890\"}";
//
//        mockMvc.perform(post("/api/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(customerJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//
//        // Verify the customer is in the database
//        Employee employee = employeeRepository.findByEmail("john.doe@example.com").orElse(null);
//        assertThat(employee).isNotNull();
//        assertThat(employee.getName()).isEqualTo("John Doe");
//
//        // Get the customer by ID
//        mockMvc.perform(get("/api/customers/" + employee.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("John Doe"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testUpdateEmployee() throws Exception {
//        // Create a new customer
//    	Employee employee = new Employee();
//    	employee.setName("Jane Doe");
//    	employee.setEmail("jane.doe@example.com");
//    	employee.setPhoneNumber("098-765-4321");
//        employeeRepository.save(employee);
//
//        // Update the customer
//        String updatedEmployeeJson = "{\"name\":\"Jane Smith\",\"email\":\"jane.smith@example.com\",\"phoneNumber\":\"098-765-4321\"}";
//
//        mockMvc.perform(put("/api/customers/" + employee.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(updatedEmployeeJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Jane Smith"))
//                .andExpect(jsonPath("$.email").value("jane.smith@example.com"));
//
//        // Verify the update in the database
//        Employee updatedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
//        assertThat(updatedEmployee).isNotNull();
//        assertThat(updatedEmployee.getName()).isEqualTo("Jane Smith");
//        assertThat(updatedEmployee.getEmail()).isEqualTo("jane.smith@example.com");
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = {"USER"})
//    public void testDeleteEmployee() throws Exception {
//        // Create a new customer with a unique email and phone number
//    	Employee employee = new Employee();
//    	employee.setName("Jane Doe");
//    	employee.setEmail("jane.doe" + UUID.randomUUID() + "@example.com"); // Ensure uniqueness
//    	employee.setPhoneNumber("098-765-4321" + UUID.randomUUID()); // Ensure uniqueness
//        employeeRepository.save(employee);
//
//        // Delete the customer
//        mockMvc.perform(delete("/api/customers/" + employee.getId())
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//
//        // Verify the customer is deleted
//        assertThat(employeeRepository.findById(employee.getId())).isEmpty();
//    }
//
//}
