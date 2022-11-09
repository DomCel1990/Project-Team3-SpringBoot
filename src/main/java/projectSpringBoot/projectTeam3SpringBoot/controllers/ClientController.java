package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.dto.ClientDTO;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;
import projectSpringBoot.projectTeam3SpringBoot.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService clientService;

    @PostMapping
    public List<Client> createClients(@RequestBody  List<Client> clients){
        return clientService.createClients(clients);
    }

    @GetMapping
    public Page<Client> getAllClients(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size){
        return clientService.getAllClients(page, size);
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable Long id) throws Exception {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public Client clientUpdate(@PathVariable Long id, @RequestBody Client client) throws Exception{
        return clientService.clientUpdate(id, client);
    }

    @DeleteMapping("/")
    public void deleteAll(){
        clientRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void clientDelete(@PathVariable Long id){
        clientService.clientDelete(id);
    }
}
