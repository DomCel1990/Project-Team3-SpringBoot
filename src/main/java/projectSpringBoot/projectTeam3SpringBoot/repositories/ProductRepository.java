package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectSpringBoot.projectTeam3SpringBoot.dto.ProductOrderDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Product;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p INNER JOIN Order o ON or_fk= o.idOrder")
    public ProductOrderDTO getProductOrder();

    @Query("SELECT p FROM Product p where p.salePrice>=?1 OR p.type=?2 OR p.description=?3")
    public List<Product> findByPrice(Double salePrice, String type, String description);
}
