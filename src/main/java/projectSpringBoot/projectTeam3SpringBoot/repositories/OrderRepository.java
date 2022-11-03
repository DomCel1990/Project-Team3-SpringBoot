package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
  /*
    @Query("SELECT o FROM Order o WHERE o.id=1")

    public List<Order> findByStatus();

    @Query("SELECT e.employee, c.client, p.products FROM Order o JOIN product p ON o.id = p.or_fk")
    public List<Order> joinProduct(@PathVariable Long id);
    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d LEFT JOIN d.employees e")
    List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
            + "FROM Department d RIGHT JOIN d.employees e")
    List<DeptEmpDto> fetchEmpDeptDataRightJoin();
*/

}
