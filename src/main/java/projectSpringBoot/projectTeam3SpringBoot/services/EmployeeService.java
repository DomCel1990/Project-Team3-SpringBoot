package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.entities.Name;
import projectSpringBoot.projectTeam3SpringBoot.entities.Role;
import projectSpringBoot.projectTeam3SpringBoot.entities.Surname;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployees(@RequestParam(required = false) int n) {
        Random random = new Random();
            for (int i = 0; i < n; i++) {
                String randomAttributeEmployee = random.ints(10, 97, 122)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                Employee employee = employeeRepository.save(new Employee(
                        Name.getRandomName().toString(),
                        Surname.getRandomSurname().toString(),
                        randomAttributeEmployee+"gmail.com",
                        random.nextInt(18,70),
                        random.nextInt(120,200),
                        random.nextBoolean(),
                        LocalDate.of(random.nextInt(1980,2022), random.nextInt(1,12),random.nextInt(1,31)),
                        Role.getRandomRoles()
                ));
            }

    }
    
    public double getSalary(Long id){
        double salary = employeeRepository.findById(id).get().calculatorSalary();
        return salary;
    }


}
