package projectSpringBoot.projectTeam3SpringBoot;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import projectSpringBoot.projectTeam3SpringBoot.controllers.EmployeeController;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void controllerTest() {
        assertThat(employeeController).isNotNull();
    }

    private List<Employee> createListEmployee() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Domenico", "Celani", "menico@gmial.com", 32, 134, false, LocalDate.of(2000, 10, 4), Role.CASHIER));
        employees.add(new Employee("Domenic5o", "Celani", "menitetro@gmial.com", 32, 134, false, LocalDate.of(2000, 10, 4), Role.CASHIER));
        return employees;
    }

    private MvcResult postEmployeeDB() throws Exception {
        String json = objectMapper.writeValueAsString(createListEmployee());

        MvcResult result = this.mockMvc.perform(post("/employee/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        return result;
    }

    private List<Employee> postEmployeeDBGetList() throws Exception {
        String json = objectMapper.writeValueAsString(createListEmployee());

        MvcResult result = this.mockMvc.perform(post("/employee/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        List<Employee> employeeList = objectMapper.readValue(postEmployeeDB().getResponse().getContentAsString(), List.class);
        return employeeList;
    }

    private Employee getEmployeeFromId(Long id) throws Exception {
        MvcResult result = this.mockMvc.perform(get("/employee/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        try {
            Employee employee1 = objectMapper.readValue(result.getResponse().getContentAsString(), Employee.class);
            return employee1;
        }catch (Exception e){
            return null;
        }
    }

    @Test
    void createEmployeesTest() throws Exception {
        List employeeList = objectMapper.readValue(postEmployeeDB().getResponse().getContentAsString(), List.class);
        assertThat(employeeList.size()).isNotZero();
    }


/*
    @Test
    void getAllEmployees() throws Exception {
        createEmployeesTest();
        MvcResult result = mockMvc
                .perform(get("/employee/?page=0&size=2").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Employee> employeeList = (List<Employee>) objectMapper.readValue(resultContent, Page.class);
        assertThat(employeeList.get(0)).isEqualTo("Domenico");
    }
*/

}
