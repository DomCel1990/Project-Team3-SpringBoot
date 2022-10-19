package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
