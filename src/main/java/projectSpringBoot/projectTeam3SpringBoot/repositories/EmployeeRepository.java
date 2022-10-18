package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entitis.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
