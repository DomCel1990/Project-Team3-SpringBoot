package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectSpringBoot.projectTeam3SpringBoot.dto.ProductOrderDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Employee;

import projectSpringBoot.projectTeam3SpringBoot.entities.Product;
import projectSpringBoot.projectTeam3SpringBoot.enu.Role;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
   @Query("SELECT p FROM Product p INNER JOIN Order o ON or_fk= o.idOrder")
    public ProductOrderDTO getProductOrder();

    @Query("SELECT p FROM Product p where p.salePrice>=?1 OR p.type=?2 OR p.description=?3")
    public List<Product> findByPrice(Double salePrice, String type,String description);
    @Query("SELECT e FROM Employee e where e.name = ?1 OR e.surname = ?2 OR e.role = ?3 OR e.email = ?4")
    public List<Employee>  findByNameORDepartment(String name, String surname, Role role, String email);
}
