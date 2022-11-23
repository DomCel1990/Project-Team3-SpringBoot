package projectSpringBoot.projectTeam3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {


    @Query("SELECT c FROM Client c WHERE c.id =:id ")
    Optional<Client> findById( Long id);

    @Query("from client where name=:name")
     Client findByName(@Param("name")String name);
}


