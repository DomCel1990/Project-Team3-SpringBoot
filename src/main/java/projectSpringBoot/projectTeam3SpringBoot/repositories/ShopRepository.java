package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
