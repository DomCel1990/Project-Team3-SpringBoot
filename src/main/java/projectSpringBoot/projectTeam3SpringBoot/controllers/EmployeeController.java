package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) throws Exception {
        if (employeeRepository.existsById(id)) {
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee;
        } else
            throw new Exception("This employee whit id: " + id + " no exist");
    }

    @PutMapping("/{id}")
    public Employee employeeUpdate(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        if(employeeRepository.existsById(id)) {
            employee.setId(id);
            Employee employeeUpdate = employeeRepository.save(employee);
            return employeeUpdate;
        }else
            throw new Exception("This employee whit id: " + id + " no exist");
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
