package projectSpringBoot.projectTeam3SpringBoot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ShopRepository;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;



}
