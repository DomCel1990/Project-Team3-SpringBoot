package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }
    @PostMapping("/createAll")
    public List<Employee> createEmployee(@RequestBody List<Employee> employees){
        List<Employee> employees1= employeeRepository.saveAllAndFlush(employees);
        return employees1;
    }
    //crea n employees
    @PostMapping("/{n}")
    public void createEmployees(@PathVariable int n){
        employeeService.createEmployees(n);
    }

    @GetMapping("/salary/{id}")
    public String getSalaryEmployee(@PathVariable Long id){
        return employeeService.getSalary(id);
    }
    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    @PostMapping("/createAll/{n}")
    public void createAll(@PathVariable int n){
        employeeService.createEmployees(n);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) throws Exception {
        if (employeeRepository.existsById(id)) {
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee;
        } else
            throw new Exception("The employee " + id + " doesn't exist");
    }

    @PutMapping("/{id}")
    public Employee employeeUpdate(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        if(employeeRepository.existsById(id)) {
            employee.setId(id);
            Employee employeeUpdate = employeeRepository.save(employee);
            return employeeUpdate;
        }else
            throw new Exception("The employee " + id + " doesn't exist");
    }

    @DeleteMapping("/{id}")
    public void employeeDelete(@PathVariable Long id){
        if(!employeeRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            employeeRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(){
        employeeRepository.deleteAll();
    }

}
