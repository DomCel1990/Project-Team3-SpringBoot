package projectSpringBoot.projectTeam3SpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.enu.Name;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;
import projectSpringBoot.projectTeam3SpringBoot.enu.Surname;
import projectSpringBoot.projectTeam3SpringBoot.repositories.EmployeeRepository;

import java.time.LocalDate;
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
                    randomAttributeEmployee + "gmail.com",
                    random.nextInt(18, 70),
                    random.nextInt(120, 200),
                    random.nextBoolean(),
                    LocalDate.of(random.nextInt(1980, 2022), random.nextInt(1, 12), random.nextInt(1, 31)),
                    Role.getRandomRoles()
            ));
        }
    }

    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    public List<Employee> createEmployees(List<Employee> employees) {
        List<Employee> employees1 = employeeRepository.saveAllAndFlush(employees);
        return employees1;
    }

    public Page<Employee> getAllEmployee(Optional<Integer> page, Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "id"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Employee> EmployeeGet = employeeRepository.findAll(pageable);
            return EmployeeGet;
        } else {
            Page<Employee> pageEmployee = Page.empty();
            return pageEmployee;
        }
    }

    public Optional<Employee> getEmployee(Long id) throws Exception {
        if (employeeRepository.existsById(id)) {
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee;
        } else
            throw new Exception("The employee " + id + " doesn't exist");
    }

    public Employee employeeUpdate(Long id, Employee employee) throws Exception {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            Employee employeeUpdate = employeeRepository.save(employee);
            return employeeUpdate;
        } else
            throw new Exception("The employee " + id + " doesn't exist");
    }

    public void employeeDelete(Long id) {
        if (!employeeRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            employeeRepository.deleteById(id);
    }
}
