package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
