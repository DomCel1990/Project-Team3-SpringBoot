package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.id=1")
    public List<Order> findByStatus();


}
