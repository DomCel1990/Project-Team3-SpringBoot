package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectSpringBoot.projectTeam3SpringBoot.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
