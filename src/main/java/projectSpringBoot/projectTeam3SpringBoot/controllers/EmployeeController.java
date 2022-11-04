package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/creates")
    public List<Employee> createEmployee(@RequestBody List<Employee> employees) {
        return employeeService.createEmployees(employees);
    }
    @Deprecated
    @PostMapping("/creates/{n}")
    public void createEmployees(@PathVariable int n) {
        employeeService.createEmployees(n);
    }


    @GetMapping("/filter")
    public List<Employee> findByNameOrSurname(@RequestParam(required = false) String name,@RequestParam(required = false) String surname,@RequestParam(required = false) Role role,@RequestParam(required = false) String email){
        return employeeRepository.findByNameORDepartment(name, surname, role, email);
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) throws Exception {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/gets")
    public Page<Employee> getAllEmployee(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        return employeeService.getAllEmployee(page, size);
    }

    @PutMapping("/{id}")
    public Employee employeeUpdate(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return employeeService.employeeUpdate(id, employee);
    }

    @DeleteMapping("/{id}")
    public void employeeDelete(@PathVariable Long id) {
        employeeService.employeeDelete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

}
