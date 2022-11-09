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

    @PostMapping("/create")
    @ApiOperation(value = "Create an Employee", notes = "Take a Object employee and save it")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/put")
    @ApiOperation(value = "Create a list of Employee", notes = "Take a list of Employee and save them")
    public List<Employee> createEmployee(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }
    @Deprecated
    @PostMapping("/creates/{n}")
    public void createEmployees(@PathVariable int n) {
        employeeService.createEmployees(n);
    }

    @GetMapping("/salary/{id}")
    @ApiOperation(value = "Find an Employee", notes = "Find an Employee by the salary")
    public EmployeeDTO getEmployeeSalary(@PathVariable Long id){
        return employeeService.getEmployeeSalary(id);
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Find the Employees", notes = "Find the Employees by the name and surname")
    public List<Employee> findByNameOrSurname(@RequestParam(required = false) String name,@RequestParam(required = false) String surname,@RequestParam(required = false) Role role,@RequestParam(required = false) String email){
        return employeeRepository.findByNameORDepartment(name, surname, role, email);
    }
    @GetMapping("/get/{id}")
    @ApiOperation(value = "Find the Employees", notes = "Find the Employees by id")
    public Optional<Employee> getEmployee(@PathVariable Long id) throws Exception {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Find the Employees", notes = "He takes the employees and makes a paged list of them")
    public Page<Employee> getAllEmployee(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return employeeService.getAllEmployee(page, size);
    }

    @PutMapping("/put/{id}")
    @ApiOperation(value = "Update Employee", notes = "Take and edit the employee by id")
    public Employee employeeUpdate(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return employeeService.employeeUpdate(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Employee", notes = "Delete the employee by id")
    public void employeeDelete(@PathVariable Long id) {
        employeeService.employeeDelete(id);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete the Employees", notes = "Delete the all employee")
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
