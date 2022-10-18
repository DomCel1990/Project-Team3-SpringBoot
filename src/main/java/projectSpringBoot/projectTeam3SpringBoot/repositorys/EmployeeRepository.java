package projectSpringBoot.projectTeam3SpringBoot.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entitis.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
