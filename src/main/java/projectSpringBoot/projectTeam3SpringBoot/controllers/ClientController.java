package projectSpringBoot.projectTeam3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projectSpringBoot.projectTeam3SpringBoot.entities.Client;
import projectSpringBoot.projectTeam3SpringBoot.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping
    public Client client(@RequestBody Client client){
        Client client1 = clientRepository.save(client);
        return client1;
    }

    @GetMapping
    public List<Client> getClients(){
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable Long id) throws Exception {
        if (clientRepository.existsById(id)) {
            Optional<Client> client = clientRepository.findById(id);
            return client;
        } else
            throw new Exception("The client " + id + " doesn't exist");
    }

    @PutMapping("/{id}")
    public Client clientUpdate(@PathVariable Long id, @RequestBody Client client) throws Exception{
        if(clientRepository.existsById(id)){
            client.setId(id);
            Client clientUpdate = clientRepository.save(client);
            return clientUpdate;
        }else
            throw new Exception("The client " + id + " doesn't exist");
    }

    @DeleteMapping
    public void deleteAll(){
        clientRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void clientDelete(@PathVariable Long id){
        if(!clientRepository.existsById(id))
            System.out.println(HttpStatus.CONFLICT);
        else
            clientRepository.deleteById(id);
    }
}
