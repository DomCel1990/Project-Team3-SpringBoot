package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.name =:name ")
    public Employee findByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e where e.name = ?1 OR e.surname = ?2 OR e.role = ?3 OR e.email = ?4")
    public List<Employee>  findByNameORDepartment(String name, String surname, Role role, String email);





}
