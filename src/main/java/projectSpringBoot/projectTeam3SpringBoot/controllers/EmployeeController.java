package projectSpringBoot.projectTeam3SpringBoot.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
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
    @ApiOperation(value = "Create a list of employee", notes = "Takes and saves a list of employees")
    public List<Employee> postEmployee(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }

    @GetMapping
    @ApiOperation(value = "Find the employees", notes = "Makes a page with all the employees")
    public Page<Employee> getAllEmployee(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return employeeService.getAllEmployee(page, size);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update employee", notes = "Finds an employee using his id and edits him")
    public Employee employeeUpdate(@PathVariable(value = "inserisci id") Long id, @RequestBody Employee employee) throws Exception {
        return employeeService.employeeUpdate(id, employee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Employee", notes = "Deletes an employee through his id")
    public void employeeDelete(@PathVariable Long id) {
        employeeService.employeeDelete(id);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete the employees", notes = "Deletes all the employees")
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
