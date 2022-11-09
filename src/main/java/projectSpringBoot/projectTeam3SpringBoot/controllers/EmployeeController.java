package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.dto.EmployeeDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @ApiOperation(value = "Create a list of Employee", notes = "Take a list of Employee and save them")
    public List<Employee> createEmployee(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }

    @GetMapping("/")
    @ApiOperation(value = "Find the Employees", notes = "He takes the employees and makes a paged list of them")
    public Page<Employee> getAllEmployee(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return employeeService.getAllEmployee(page, size);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Employee", notes = "Take and edit the employee by id")
    public Employee employeeUpdate(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return employeeService.employeeUpdate(id, employee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Employee", notes = "Delete the employee by id")
    public void employeeDelete(@PathVariable Long id) {
        employeeService.employeeDelete(id);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete the Employees", notes = "Delete the all employee")
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
